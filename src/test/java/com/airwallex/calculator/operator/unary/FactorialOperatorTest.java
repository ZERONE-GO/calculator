package com.airwallex.calculator.operator.unary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.main.component.RealNumber;

@SpringBootTest
public class FactorialOperatorTest {

    @Test
    public void testFactorial() {
        RealNumber a = new RealNumber(5);

        FactorialOperator operator = new FactorialOperator();
        Assertions.assertEquals(120, operator.calc(a.getValue()));
    }

    @Test
    public void testFactorial2() {
        RealNumber a = new RealNumber(-1.0);

        FactorialOperator operator = new FactorialOperator();
        Assertions.assertEquals(Double.NaN, operator.calc(a.getValue()));
    }

    @Test
    public void testFactorial3() {
        RealNumber a = new RealNumber(5.4);

        FactorialOperator operator = new FactorialOperator();
        Assertions.assertEquals(Double.NaN, operator.calc(a.getValue()));
    }

}
