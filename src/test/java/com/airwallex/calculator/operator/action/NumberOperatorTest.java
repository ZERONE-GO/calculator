package com.airwallex.calculator.operator.action;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.airwallex.calculator.main.component.NumberStack;
import com.airwallex.calculator.main.component.OperatorStack;
import com.airwallex.calculator.main.component.RealNumber;
import com.airwallex.calculator.operator.action.NumberOperator;
import com.airwallex.calculator.operator.error.ErrorMessage;

@SpringBootTest
public class NumberOperatorTest {

    @Test
    public void testOperate() throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);

        NumberOperator operator = new NumberOperator("123456789.0123456789");
        operator.operate(numberStack, operatorStack);

        Field field = NumberOperator.class.getDeclaredField("number");
        field.setAccessible(true);
        RealNumber number = (RealNumber) field.get(operator);

        Assertions.assertEquals(new RealNumber(123456789.0123456789).getValue(), number.getValue());
        Mockito.verify(numberStack, Mockito.times(1)).push(number);
        Mockito.verify(operatorStack, Mockito.times(1)).push(operator);
    }

    @Test
    public void testOperateWithErrorMessage() {
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);

        NumberOperator operator = new NumberOperator("9k");
        Assertions.assertEquals(false, operator.operate(numberStack, operatorStack));
        Assertions.assertEquals(ErrorMessage.INSUFFICIENT_PARAMETERS, operator.getErrorMessage());
    }
    
    @Test
    public void testUndo() {
        NumberStack numberStack = Mockito.mock(NumberStack.class);
        OperatorStack operatorStack = Mockito.mock(OperatorStack.class);
        NumberOperator operator = new NumberOperator("123");
        operator.undo(numberStack, operatorStack);
        Mockito.verify(numberStack, Mockito.times(1)).pop();
        Mockito.verify(operatorStack, Mockito.times(1)).pushUndo(operator);
    }

}
