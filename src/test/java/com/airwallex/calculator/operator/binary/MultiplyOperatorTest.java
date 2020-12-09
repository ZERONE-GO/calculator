package com.airwallex.calculator.operator.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.RealNumber;

@SpringBootTest
public class MultiplyOperatorTest {
    
    @Test
    public void testMultiply() {
        RealNumber a = new RealNumber(500);
        RealNumber b = new RealNumber(20);

        MultiplyOperator operator = new MultiplyOperator();
        Assertions.assertEquals(10000, operator.calc(a.getValue(), b.getValue()));
    }

}
