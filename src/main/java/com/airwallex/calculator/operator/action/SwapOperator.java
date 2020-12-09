package com.airwallex.calculator.operator.action;

import com.airwallex.calculator.component.NumberStack;
import com.airwallex.calculator.component.OperatorStack;
import com.airwallex.calculator.component.RealNumber;
import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.anotation.OperatorCommand;
import com.airwallex.calculator.operator.error.ErrorMessage;

@OperatorCommand(SwapOperator.SWAP)
public class SwapOperator extends Operator {

    public static final String SWAP = "swap";

    /**
     * operation number a;
     */
    private RealNumber a;

    /**
     * operation number b;
     */
    private RealNumber b;

    @Override
    public boolean operate(NumberStack numberStack, OperatorStack operatorStack) {
        b = numberStack.pop();
        a = numberStack.pop();

        if (a == null || b == null) {
            if (b != null) {
                numberStack.push(b);
            }
            this.errorMessage = ErrorMessage.INSUFFICIENT_PARAMETERS;
            return false;
        }
        numberStack.push(b);
        numberStack.push(a);
        operatorStack.push(this);
        return true;
    }

    @Override
    public void undo(NumberStack numberStack, OperatorStack operatorStack) {
        if (a != null && b != null) {
            numberStack.pop();
            numberStack.pop();
            numberStack.push(a);
            numberStack.push(b);
            operatorStack.pushUndo(this);
        }
    }

}
