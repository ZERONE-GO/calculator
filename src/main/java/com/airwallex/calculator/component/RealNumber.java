package com.airwallex.calculator.component;

import java.math.BigDecimal;

public class RealNumber {

    private static final double EPS = 1e-10;

    /**
     * valid decimal length
     */
    private static final int DECIMAL_LENGTH = 10;

    private final double value;

    public RealNumber(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    /**
     * Numbers should be stored on the stack to at least 15 decimal places of
     * precision, but displayed to 10 decimal places (or less if it causes no loss
     * of precision).
     * 
     */
    public String toString() {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return String.valueOf(value);
        }

        double r = round(value);
        if (isInteger(r)) {
            // For performance purpose. if the value less than integer, convert to int
            // directly. Otherwise use BigInteger instead.
            if (r <= Integer.MAX_VALUE) {
                return String.valueOf((int) r);
            } else {
                BigDecimal bd = new BigDecimal(r);
                return bd.toBigInteger().toString();
            }
        }
        return String.valueOf(r);
    }

    /**
     * convert 15 decimal to 10 decimal
     * 
     * @param v
     * @return
     */
    private double round(double v) {
        BigDecimal bd = new BigDecimal(v);
        // Use follow solution to increase the precision of double calculation, ex. 0.06
        // + 0.01.
        bd = bd.setScale(DECIMAL_LENGTH + 1, BigDecimal.ROUND_HALF_UP);
        // truncates the part which more than 10 decimal, sqrt 2 =
        // 1.4142135623.(ROUND_DOWN)
        bd = bd.setScale(DECIMAL_LENGTH, BigDecimal.ROUND_DOWN);
        return bd.doubleValue();
    }

    /**
     * check real number is integer or not.
     */
    private boolean isInteger(double v) {
        return v - Math.floor(v) < EPS;
    }

}
