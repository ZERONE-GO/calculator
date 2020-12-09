package com.airwallex.calculator.operator.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.RealNumber;

@SpringBootTest
public class MinusOperatorTest {

    @Test
    public void testMinus() {
        RealNumber a = new RealNumber(500);
        RealNumber b = new RealNumber(20);

        MinusOperator operator = new MinusOperator();
        Assertions.assertEquals(480, operator.calc(a.getValue(), b.getValue()));
    }
}
