package com.airwallex.calculator.operator.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.main.component.RealNumber;

@SpringBootTest
public class PlusOperatorTest {

    @Test
    public void testPlus() {
        RealNumber a = new RealNumber(500);
        RealNumber b = new RealNumber(20);

        PlusOperator operator = new PlusOperator();
        Assertions.assertEquals(520, operator.calc(a.getValue(), b.getValue()));
    }
}
