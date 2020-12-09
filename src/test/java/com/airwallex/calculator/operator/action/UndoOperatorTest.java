package com.airwallex.calculator.operator.action;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.NumberStack;
import com.airwallex.calculator.component.OperatorStack;
import com.airwallex.calculator.operator.Operator;

@SpringBootTest
public class UndoOperatorTest {

    @Test
    public void testOperate() {
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);
        Operator operator = Mockito.mock(Operator.class);

        Mockito.when(operatorStack.pop()).thenReturn(operator);

        UndoOperator undoOperator = new UndoOperator();
        undoOperator.operate(numberStack, operatorStack);

        Mockito.verify(operator, Mockito.times(1)).undo(numberStack, operatorStack);
    }

}
