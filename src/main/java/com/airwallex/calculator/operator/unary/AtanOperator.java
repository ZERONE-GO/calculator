package com.airwallex.calculator.operator.unary;

import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(AtanOperator.ATAN)
public class AtanOperator extends UnaryOperator {

    public static final String ATAN = "atan";

    @Override
    protected double calc(double num) {
        return Math.atan(num);
    }

}
