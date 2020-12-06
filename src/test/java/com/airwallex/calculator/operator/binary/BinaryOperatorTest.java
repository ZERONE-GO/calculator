package com.airwallex.calculator.operator.binary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.main.component.NumberStack;
import com.airwallex.calculator.main.component.OperatorStack;
import com.airwallex.calculator.main.component.RealNumber;
import com.airwallex.calculator.operator.error.ErrorMessage;

@SpringBootTest
public class BinaryOperatorTest {

    @Test
    public void testOperateUndo() {
        BinaryOperator operator = Mockito.mock(BinaryOperator.class, Mockito.CALLS_REAL_METHODS);
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);
        RealNumber b = Mockito.mock(RealNumber.class);
        RealNumber a = Mockito.mock(RealNumber.class);

        Mockito.when(numberStack.pop()).thenReturn(b, a);
        operator.operate(numberStack, operatorStack);

        Mockito.verify(numberStack, Mockito.times(2)).pop();
        Mockito.verify(operator, Mockito.times(1)).calc(a.getValue(), b.getValue());
        Mockito.verify(operatorStack, Mockito.times(1)).push(operator);
        
        operator.undo(numberStack, operatorStack);
        Mockito.verify(numberStack, Mockito.times(1)).push(b);
        Mockito.verify(numberStack, Mockito.times(1)).push(a);
        Mockito.verify(operatorStack, Mockito.times(1)).pushUndo(operator);
    }
    
    @Test
    public void testOperateUndoWithANull() {
        BinaryOperator operator = Mockito.mock(BinaryOperator.class, Mockito.CALLS_REAL_METHODS);
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);
        RealNumber b = Mockito.mock(RealNumber.class);

        Mockito.when(numberStack.pop()).thenReturn(b, null);

        Assertions.assertEquals(false, operator.operate(numberStack, operatorStack));
        Mockito.verify(numberStack, Mockito.times(2)).pop();
        Assertions.assertEquals(ErrorMessage.INSUFFICIENT_PARAMETERS, operator.getErrorMessage());
        
        operator.undo(numberStack, operatorStack);
        Mockito.verify(operatorStack, Mockito.never()).pushUndo(operator);
    }
}
