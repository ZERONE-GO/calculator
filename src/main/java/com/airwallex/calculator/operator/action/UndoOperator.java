package com.airwallex.calculator.operator.action;

import com.airwallex.calculator.component.NumberStack;
import com.airwallex.calculator.component.OperatorStack;
import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.anotation.OperatorCommand;

@OperatorCommand(UndoOperator.UNDO)
public class UndoOperator extends Operator {
    public static final String UNDO = "undo";

    @Override
    public boolean operate(NumberStack numberStack, OperatorStack operatorStack) {
        Operator operator = operatorStack.pop();

        // do nothing when there is not operator in the history
        if (operator != null) {
            operator.undo(numberStack, operatorStack);
        }
        return true;
    }

    @Override
    public void undo(NumberStack numberStack, OperatorStack operationStack) {
        // DO NOTHING
    }

}
