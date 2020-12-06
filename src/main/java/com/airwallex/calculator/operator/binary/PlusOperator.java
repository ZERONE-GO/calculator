package com.airwallex.calculator.operator.binary;

import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(PlusOperator.PLUS)
public class PlusOperator extends BinaryOperator {
    public static final String PLUS = "+";

    @Override
    protected double calc(double a, double b) {
        return a + b;
    }

}
