package com.airwallex.calculator;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.airwallex.calculator.main.RpnCalculator;
import com.airwallex.calculator.operator.factory.OperatorFactory;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CalculatorApplication.class, args);
        RpnCalculator calculator = new RpnCalculator(context.getBean(OperatorFactory.class));

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (StringUtils.isNotBlank(input)) {
            System.out.println(calculator.calculate(input));
            input = sc.nextLine();
        }
        sc.close();
    }

}