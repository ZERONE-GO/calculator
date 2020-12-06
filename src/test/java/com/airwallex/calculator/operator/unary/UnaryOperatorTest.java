package com.airwallex.calculator.operator.unary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.main.component.NumberStack;
import com.airwallex.calculator.main.component.OperatorStack;
import com.airwallex.calculator.main.component.RealNumber;
import com.airwallex.calculator.operator.binary.BinaryOperator;
import com.airwallex.calculator.operator.error.ErrorMessage;

@SpringBootTest
public class UnaryOperatorTest {

    @Test
    public void testOperateUndo() {
        UnaryOperator operator = Mockito.mock(UnaryOperator.class, Mockito.CALLS_REAL_METHODS);
        
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);
        RealNumber a = Mockito.mock(RealNumber.class);

        Mockito.when(numberStack.pop()).thenReturn(a);
        operator.operate(numberStack, operatorStack);

        Mockito.verify(numberStack, Mockito.times(1)).pop();
        Mockito.verify(operator, Mockito.times(1)).calc(a.getValue());
        Mockito.verify(operatorStack, Mockito.times(1)).push(operator);
        
        operator.undo(numberStack, operatorStack);
        Mockito.verify(numberStack, Mockito.times(1)).push(a);
        Mockito.verify(operatorStack, Mockito.times(1)).pushUndo(operator);
    }
    
    @Test
    public void testOperateUndoWithANull() {
        UnaryOperator operator = Mockito.mock(UnaryOperator.class, Mockito.CALLS_REAL_METHODS);
        
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);

        Mockito.when(numberStack.pop()).thenReturn(null);
        operator.operate(numberStack, operatorStack);

        Assertions.assertEquals(false, operator.operate(numberStack, operatorStack));
        Assertions.assertEquals(ErrorMessage.INSUFFICIENT_PARAMETERS, operator.getErrorMessage());
        
        operator.undo(numberStack, operatorStack);
        Mockito.verify(operatorStack, Mockito.never()).pushUndo(operator);
    }
}
