package com.airwallex.calculator.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.NumberStack;
import com.airwallex.calculator.component.RealNumber;

@SpringBootTest
public class NumberStackTest {

    @Test
    public void testPush() {
        NumberStack numberStack = new NumberStack();
        RealNumber a = new RealNumber(1.0);
        numberStack.push(a);
        Assertions.assertEquals("stack: 1", numberStack.toString());
        Assertions.assertEquals(a, numberStack.pop());
    }

    @Test
    public void testPop() {
        NumberStack numberStack = new NumberStack();
        RealNumber a = new RealNumber(2);
        numberStack.push(a);
        Assertions.assertEquals(a, numberStack.pop());
        Assertions.assertEquals(null, numberStack.pop());
        Assertions.assertEquals(null, numberStack.pop());
    }

    @Test
    public void testToString() {
        NumberStack numberStack = new NumberStack();
        RealNumber a = new RealNumber(1);
        numberStack.push(a);
        RealNumber b = new RealNumber(2);
        numberStack.push(b);
        Assertions.assertEquals("stack: 1 2", numberStack.toString());
    }

    @Test
    public void testClear() {
        NumberStack numberStack = new NumberStack();
        RealNumber a = new RealNumber(1);
        numberStack.push(a);
        RealNumber b = new RealNumber(2);
        numberStack.push(b);
        Assertions.assertEquals("stack: 1 2", numberStack.toString());
        numberStack.clear();
        Assertions.assertEquals("stack:", numberStack.toString());
        Assertions.assertEquals(null, numberStack.pop());
    }
}
