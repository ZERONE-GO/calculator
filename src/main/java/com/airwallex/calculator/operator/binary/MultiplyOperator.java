package com.airwallex.calculator.operator.binary;

import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(MultiplyOperator.MULTIPLY)
public class MultiplyOperator extends BinaryOperator {
    /**
     * multiply operator command
     */
    public static final String MULTIPLY = "*";

    @Override
    protected double calc(double a, double b) {
        return a * b;
    }

}
