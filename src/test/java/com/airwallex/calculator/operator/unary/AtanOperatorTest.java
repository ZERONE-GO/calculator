package com.airwallex.calculator.operator.unary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.RealNumber;

@SpringBootTest
public class AtanOperatorTest {
    
    @Test
    public void testAtan() {
        RealNumber a = new RealNumber(1);

        AtanOperator operator = new AtanOperator();
        Assertions.assertEquals(Math.atan(1), operator.calc(a.getValue()));
    }
    

}
