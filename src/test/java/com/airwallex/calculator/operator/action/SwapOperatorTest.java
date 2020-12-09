package com.airwallex.calculator.operator.action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.component.NumberStack;
import com.airwallex.calculator.component.OperatorStack;
import com.airwallex.calculator.component.RealNumber;
import com.airwallex.calculator.operator.error.ErrorMessage;

@SpringBootTest
public class SwapOperatorTest {

    @Test
    public void testOperateUndo() {
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);
        RealNumber b = Mockito.mock(RealNumber.class);
        RealNumber a = Mockito.mock(RealNumber.class);

        Mockito.when(numberStack.pop()).thenReturn(b, a);
        SwapOperator operator = new SwapOperator();
        operator.operate(numberStack, operatorStack);

        Mockito.verify(numberStack, Mockito.times(2)).pop();
        Mockito.verify(numberStack, Mockito.times(1)).push(b);
        Mockito.verify(numberStack, Mockito.times(1)).push(a);
        Mockito.verify(operatorStack, Mockito.times(1)).push(operator);
        
        operator.undo(numberStack, operatorStack);
        Mockito.verify(operatorStack, Mockito.times(1)).pushUndo(operator);
    }
    
    @Test
    public void testOperateUndoWithANull() {
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);
        RealNumber b = Mockito.mock(RealNumber.class);

        Mockito.when(numberStack.pop()).thenReturn(b, null);
        SwapOperator operator = new SwapOperator();
        operator.operate(numberStack, operatorStack);

        Mockito.verify(numberStack, Mockito.times(1)).push(b);
        Assertions.assertEquals(ErrorMessage.INSUFFICIENT_PARAMETERS, operator.getErrorMessage());
        Mockito.verify(operatorStack, Mockito.never()).push(operator);
        
        operator.undo(numberStack, operatorStack);
        Mockito.verify(operatorStack, Mockito.never()).pushUndo(operator);
    }
    
    @Test
    public void testOperateUndoWithABNull() {
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);

        Mockito.when(numberStack.pop()).thenReturn(null, null);
        SwapOperator operator = new SwapOperator();
        operator.operate(numberStack, operatorStack);

        Mockito.verify(numberStack, Mockito.never()).push(null);
        Assertions.assertEquals(ErrorMessage.INSUFFICIENT_PARAMETERS, operator.getErrorMessage());
        Mockito.verify(operatorStack, Mockito.never()).push(operator);
        
        operator.undo(numberStack, operatorStack);
        Mockito.verify(operatorStack, Mockito.never()).pushUndo(operator);
    }
}
