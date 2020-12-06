package com.airwallex.calculator.operator.action;

import com.airwallex.calculator.main.component.NumberStack;
import com.airwallex.calculator.main.component.OperatorStack;
import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(ClearOperator.CLEAR)
public class ClearOperator extends Operator {

    public static final String CLEAR = "clear";

    @Override
    public boolean operate(NumberStack numberStack, OperatorStack operatorStack) {
        numberStack.clear();
        operatorStack.clear();
        return true;
    }

    @Override
    public void undo(NumberStack numberStack, OperatorStack operatorStack) {
        // DO NOTHING
    }

}
