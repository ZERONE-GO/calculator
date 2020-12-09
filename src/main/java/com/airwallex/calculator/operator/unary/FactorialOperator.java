package com.airwallex.calculator.operator.unary;

import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(FactorialOperator.FACTORIAL)
public class FactorialOperator extends UnaryOperator {

    public static final String FACTORIAL = "!";

    private static final double EPS = 1e-10;

    @Override
    protected double calc(double num) {
        if (!isNatureNumber(num)) {
            return Double.NaN;
        }

        // 171 ! = Infinity
        if (num > 170) {
            return Double.POSITIVE_INFINITY;
        }

        int integer = (int) num;
        double result = 1.0;
        for (int i = 1; i <= integer; i++) {
            result *= i;
        }

        return result;
    }

    private boolean isNatureNumber(double num) {
        return num >= 0 && num - Math.floor(num) < EPS;
    }

}
