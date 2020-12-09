package com.airwallex.calculator.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.OperatorStack;
import com.airwallex.calculator.operator.Operator;

@SpringBootTest
public class OperatorStackTest {

    @Test
    public void testPush() {
        OperatorStack stack = new OperatorStack();

        Operator op1 = Mockito.mock(Operator.class);
        stack.push(op1);
        Assertions.assertEquals(op1, stack.pop());
        stack.push(op1);

        Operator op2 = Mockito.mock(Operator.class);
        stack.push(op2);
        Assertions.assertEquals(op2, stack.pop());
        Assertions.assertEquals(op1, stack.pop());

        stack.pushUndo(op2);
        stack.push(op1);
        Assertions.assertEquals(op1, stack.pop());
        Assertions.assertEquals(null, stack.popUndo());
    }

    @Test
    public void testRedo() {
        OperatorStack stack = new OperatorStack();

        Operator op2 = Mockito.mock(Operator.class);
        stack.pushUndo(op2);

        stack.startRedo();
        Operator op1 = Mockito.mock(Operator.class);
        stack.push(op1);
        Assertions.assertEquals(op1, stack.pop());
        Assertions.assertEquals(op2, stack.popUndo());

        stack.closeRedo();
        stack.pushUndo(op2);
        stack.push(op1);
        Assertions.assertEquals(op1, stack.pop());
        Assertions.assertEquals(null, stack.popUndo());
    }

    public void testClear() {
        OperatorStack stack = new OperatorStack();

        Operator op2 = Mockito.mock(Operator.class);
        stack.pushUndo(op2);
        Operator op1 = Mockito.mock(Operator.class);
        stack.push(op1);

        stack.clear();

        Assertions.assertEquals(null, stack.pop());
        Assertions.assertEquals(null, stack.popUndo());
    }

}
