package com.airwallex.calculator.main;

import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import com.airwallex.calculator.main.component.NumberStack;
import com.airwallex.calculator.main.component.OperatorStack;
import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.factory.OperatorFactory;

public class RpnCalculator {

    /**
     * The real number stack
     */
    private NumberStack numberStack;

    /**
     * the operator stack
     */
    private OperatorStack operatorStack;

    /**
     * the delimter to tokenize the RPN input
     */
    private static final String DELIMITERS = " \t\n\r\f";

    private OperatorFactory operatorFactory;

    public RpnCalculator(OperatorFactory operatorFactory) {
        this.numberStack = new NumberStack();
        this.operatorStack = new OperatorStack();
        this.operatorFactory = operatorFactory;
    }

    public String calculate(String rpnStr) {
        StringBuilder builder = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer(rpnStr, DELIMITERS, true);
        int pos = 1;
        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();

            if (StringUtils.isNotBlank(token)) {
                Operator operator = operatorFactory.generateOperator(token);
                boolean success = operator.operate(numberStack, operatorStack);
                if (!success) {
                    builder.append(String.format("operator %s (position: %d): %s\r\n", token, pos,
                            operator.getErrorMessage()));
                    break;
                }
            }
            pos += token.length();
        }

        builder.append(numberStack.toString());
        return builder.toString();
    }

}
