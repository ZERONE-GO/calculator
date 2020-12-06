package com.airwallex.calculator.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.main.RpnCalculator;
import com.airwallex.calculator.operator.factory.OperatorFactory;

@SpringBootTest
public class RpnCalculatorTest {

    @Autowired
    private OperatorFactory operatorFactory;

    @Test
    public void testExample1() {
        RpnCalculator calculator = new RpnCalculator(operatorFactory);
        Assertions.assertEquals("stack: 5 2", calculator.calculate("5 2"));
    }

    @Test
    public void testExample2() {
        RpnCalculator calculator = new RpnCalculator(operatorFactory);
        Assertions.assertEquals("stack: 1.4142135623", calculator.calculate("2 sqrt"));
        Assertions.assertEquals("stack: 3", calculator.calculate("clear 9 sqrt"));
    }

    @Test
    public void testExample3() {
        RpnCalculator calculator = new RpnCalculator(operatorFactory);
        Assertions.assertEquals("stack: 3", calculator.calculate("5 2 -"));
        Assertions.assertEquals("stack: 0", calculator.calculate("3 -"));
        Assertions.assertEquals("stack:", calculator.calculate("clear"));
    }

    @Test
    public void testExample4() {
        RpnCalculator calculator = new RpnCalculator(operatorFactory);
        Assertions.assertEquals("stack: 5 4 3 2", calculator.calculate("5 4 3 2"));
        Assertions.assertEquals("stack: 20", calculator.calculate("undo undo *"));
        Assertions.assertEquals("stack: 100", calculator.calculate("5 *"));
        Assertions.assertEquals("stack: 20 5", calculator.calculate("undo"));
    }

    @Test
    public void testExample5() {
        RpnCalculator calculator = new RpnCalculator(operatorFactory);
        Assertions.assertEquals("stack: 7 6", calculator.calculate("7 12 2 /"));
        Assertions.assertEquals("stack: 42", calculator.calculate("*"));
        Assertions.assertEquals("stack: 10.5", calculator.calculate("4 /"));
    }

    @Test
    public void testExample6() {
        RpnCalculator calculator = new RpnCalculator(operatorFactory);
        Assertions.assertEquals("stack: 1 2 3 4 5", calculator.calculate("1 2 3 4 5"));
        Assertions.assertEquals("stack: 1 2 3 20", calculator.calculate("*"));
        Assertions.assertEquals("stack: -1", calculator.calculate("clear 3 4 -"));
    }

    @Test
    public void testExample7() {
        RpnCalculator calculator = new RpnCalculator(operatorFactory);
        Assertions.assertEquals("stack: 1 2 3 4 5", calculator.calculate("1 2 3 4 5"));
        Assertions.assertEquals("stack: 120", calculator.calculate("* * * *"));
    }

    @Test
    public void testExample8() {
        RpnCalculator calculator = new RpnCalculator(operatorFactory);
        Assertions.assertEquals("operator * (position: 15): insufficient parameters\r\nstack: 11",
                calculator.calculate("1 2 3 * 5 + * * 6 5"));
    }

}
