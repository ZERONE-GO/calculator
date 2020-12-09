package com.airwallex.calculator.operator.action;

import com.airwallex.calculator.component.NumberStack;
import com.airwallex.calculator.component.OperatorStack;
import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(RedoOperator.REDO)
public class RedoOperator extends Operator {

    public static final String REDO = "redo";

    @Override
    public boolean operate(NumberStack numberStack, OperatorStack operatorStack) {
        Operator operator = operatorStack.popUndo();
        if(operator != null) {
            operatorStack.startRedo();
            operator.operate(numberStack, operatorStack);
            operatorStack.closeRedo();
        }
        return true;
    }

    @Override
    public void undo(NumberStack numberStack, OperatorStack operatorStack) {
        // DO NOTHING
    }

}
