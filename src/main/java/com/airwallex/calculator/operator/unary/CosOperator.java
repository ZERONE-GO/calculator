package com.airwallex.calculator.operator.unary;

import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(CosOperator.COS)
public class CosOperator extends UnaryOperator {

    public static final String COS = "cos";

    @Override
    protected double calc(double num) {
        return Math.cos(num);
    }

}
