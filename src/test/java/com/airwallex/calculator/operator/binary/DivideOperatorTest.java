package com.airwallex.calculator.operator.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.RealNumber;

@SpringBootTest
public class DivideOperatorTest {

    @Test
    public void testDivide() {
        RealNumber a = new RealNumber(500);
        RealNumber b = new RealNumber(20);

        DivideOperator operator = new DivideOperator();
        Assertions.assertEquals(25, operator.calc(a.getValue(), b.getValue()));
    }
    
    @Test
    public void testDivideZero() {
        RealNumber a = new RealNumber(500);
        RealNumber b = new RealNumber(0);

        DivideOperator operator = new DivideOperator();
        Assertions.assertEquals(Double.POSITIVE_INFINITY, operator.calc(a.getValue(), b.getValue()));
    }

}
