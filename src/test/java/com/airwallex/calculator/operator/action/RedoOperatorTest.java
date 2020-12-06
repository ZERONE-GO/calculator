package com.airwallex.calculator.operator.action;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.main.component.NumberStack;
import com.airwallex.calculator.main.component.OperatorStack;
import com.airwallex.calculator.operator.Operator;

@SpringBootTest
public class RedoOperatorTest {

    @Test
    public void testOperate() {
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);
        Operator operator = Mockito.mock(Operator.class);

        Mockito.when(operatorStack.popUndo()).thenReturn(operator);

        RedoOperator redoOperator = new RedoOperator();
        redoOperator.operate(numberStack, operatorStack);

        Mockito.verify(operatorStack, Mockito.times(1)).startRedo();
        Mockito.verify(operatorStack, Mockito.times(1)).closeRedo();
        Mockito.verify(operator, Mockito.times(1)).operate(numberStack, operatorStack);
    }

    @Test
    public void testOperateWithEmptyOperatorStack() {
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);
        RedoOperator redoOperator = new RedoOperator();
        redoOperator.operate(numberStack, operatorStack);

        Mockito.verify(operatorStack, Mockito.times(0)).startRedo();
        Mockito.verify(operatorStack, Mockito.times(0)).closeRedo();
    }

}
