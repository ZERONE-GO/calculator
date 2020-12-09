package com.airwallex.calculator.operator.unary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.RealNumber;

@SpringBootTest
public class SqrtOperatorTest {

    @Test
    public void testSqrt() {
        RealNumber a = new RealNumber(5);

        SqrtOperator operator = new SqrtOperator();
        Assertions.assertEquals(Math.sqrt(5), operator.calc(a.getValue()));
    }

    @Test
    public void testSqrt2() {
        RealNumber a = new RealNumber(-1.0);

        FactorialOperator operator = new FactorialOperator();
        Assertions.assertEquals(Double.NaN, operator.calc(a.getValue()));
    }

}
