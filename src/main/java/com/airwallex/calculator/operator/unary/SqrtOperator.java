package com.airwallex.calculator.operator.unary;

import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(SqrtOperator.SQRT)
public class SqrtOperator extends UnaryOperator {

    public static final String SQRT = "sqrt";

    /**
     * will return Double.NaN when number is less than 0.
     */
    @Override
    protected double calc(double num) {
        return Math.sqrt(num);
    }

}
