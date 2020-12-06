package com.airwallex.calculator.operator.binary;

import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(DivideOperator.DIVIDE)
public class DivideOperator extends BinaryOperator {

    public static final String DIVIDE = "/";

    /**
     * did not check if b is 0, it will return Infinite when b is zero.
     */
    @Override
    protected double calc(double a, double b) {
        return a / b;
    }

}
