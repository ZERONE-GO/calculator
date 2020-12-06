package com.airwallex.calculator.operator.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.action.NumberOperator;
import com.airwallex.calculator.operator.anotation.OperatorCommand;

@Component
public class OperatorFactory {

    private static final Logger logger = LoggerFactory.getLogger(OperatorFactory.class);

    private static Map<String, Class<?>> operatorMap = new HashMap<>();

    static {
        // scan operator package
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .forPackages("com.airwallex.calculator.operator").addScanners(new FieldAnnotationsScanner()));

        // get all operators
        Set<Class<?>> clazzSet = reflections.getTypesAnnotatedWith(OperatorCommand.class);
        for (Class<?> clazz : clazzSet) {
            if (Operator.class.isAssignableFrom(clazz)) {
                OperatorCommand annotation = clazz.getDeclaredAnnotation(OperatorCommand.class);
                operatorMap.put(annotation.value().toLowerCase(), clazz);
                logger.info(String.format("Successfully loading %s operator", clazz));
            } else {
                logger.warn(String.format("Can not load %s operator as it is not the subclass of com.airwallex.calculator.operator.Operator.", clazz));
            }
        }
    }

    public Operator generateOperator(String operation) {
        Class<?> c = operatorMap.get(operation.toLowerCase());

        if (c != null) {
            try {
                return (Operator)c.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                logger.error("Cannot generate Operator", e);
                throw new RuntimeException(e);
            }
        } else {
            return new NumberOperator(operation);
        }
    }

}
