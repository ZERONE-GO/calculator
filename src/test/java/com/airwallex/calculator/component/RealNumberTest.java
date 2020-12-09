package com.airwallex.calculator.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.RealNumber;

@SpringBootTest
public class RealNumberTest {

    @Test
    public void testInteger() {
        RealNumber integer1 = new RealNumber(123456789);
        Assertions.assertEquals(integer1.toString(), "123456789");

        RealNumber integer2 = new RealNumber(100.0);
        Assertions.assertEquals(integer2.toString(), "100");

        RealNumber integer3 = new RealNumber(+999);
        Assertions.assertEquals(integer3.toString(), "999");

        RealNumber integer4 = new RealNumber(-123456789);
        Assertions.assertEquals(integer4.toString(), "-123456789");

        // big number
        RealNumber integer5 = new RealNumber(Integer.MAX_VALUE);
        Assertions.assertEquals(integer5.toString(), "2147483647");

        // big than integer
        RealNumber integer7 = new RealNumber(2147483648.0);
        Assertions.assertEquals(integer7.toString(), "2147483648");

        // big than long max value
        RealNumber integer6 = new RealNumber(9223372036854775808.0);
        Assertions.assertEquals(integer6.toString(), "9223372036854775808");
    }

    @Test
    public void testDouble() {
        // double
        RealNumber d1 = new RealNumber(1.0123456789);
        Assertions.assertEquals(d1.toString(), "1.0123456789");

        RealNumber d2 = new RealNumber(-1.0123456789);
        Assertions.assertEquals(d2.toString(), "-1.0123456789");
    }

    @Test
    public void testDecimal() {
        RealNumber d1 = new RealNumber(1.01234567894321);
        Assertions.assertEquals(d1.toString(), "1.0123456789");

        RealNumber d2 = new RealNumber(-1.01234567894321);
        Assertions.assertEquals(d2.toString(), "-1.0123456789");

        RealNumber d3 = new RealNumber(1.01234567895678);
        Assertions.assertEquals(d3.toString(), "1.0123456789");

        RealNumber d4 = new RealNumber(-1.01234567895678);
        Assertions.assertEquals(d4.toString(), "-1.0123456789");
    }

    @Test
    public void testPrecision() {
        RealNumber p1 = new RealNumber(0.06 + 0.01);
        Assertions.assertEquals(p1.toString(), "0.07");

        RealNumber p2 = new RealNumber(1.0 - 0.42);
        Assertions.assertEquals(p2.toString(), "0.58");

        RealNumber p3 = new RealNumber(4.015 * 100);
        Assertions.assertEquals(p3.toString(), "401.5");

        RealNumber p4 = new RealNumber(303.1 / 1000);
        Assertions.assertEquals(p4.toString(), "0.3031");
    }
}
