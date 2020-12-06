package com.airwallex.calculator.operator.unary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.main.component.RealNumber;

@SpringBootTest
public class CosOperatorTest {
    
    @Test
    public void testCos() {
        RealNumber a = new RealNumber(1);

        CosOperator operator = new CosOperator();
        Assertions.assertEquals(Math.cos(1), operator.calc(a.getValue()));
    }
    

}
