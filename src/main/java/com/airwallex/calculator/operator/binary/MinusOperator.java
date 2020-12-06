package com.airwallex.calculator.operator.binary;

import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(MinusOperator.MINUS)
public class MinusOperator extends BinaryOperator {
    
    public static final String MINUS = "-";

    @Override
    protected double calc(double a, double b) {
        return a - b;
    }

}
