package com.airwallex.calculator.operator.action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.NumberStack;
import com.airwallex.calculator.component.OperatorStack;
import com.airwallex.calculator.operator.action.ClearOperator;

@SpringBootTest
public class ClearOperatorTest {

    @Test
    public void testCommand() {
        Assertions.assertEquals("clear", ClearOperator.CLEAR.toLowerCase());
    }

    @Test
    public void testOperate() {
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);

        ClearOperator operator = new ClearOperator();
        operator.operate(numberStack, operatorStack);

        Mockito.verify(numberStack, Mockito.times(1)).clear();
        Mockito.verify(operatorStack, Mockito.times(1)).clear();
    }
}
