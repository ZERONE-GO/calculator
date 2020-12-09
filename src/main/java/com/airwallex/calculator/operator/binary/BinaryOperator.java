package com.airwallex.calculator.operator.binary;

import com.airwallex.calculator.component.NumberStack;
import com.airwallex.calculator.component.OperatorStack;
import com.airwallex.calculator.component.RealNumber;
import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.error.ErrorMessage;

public abstract class BinaryOperator extends Operator {
    /**
     * operation number a
     */
    protected RealNumber a;

    /**
     * operation number b
     */
    protected RealNumber b;

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
        numberStack.push(new RealNumber(calc(a.getValue(), b.getValue())));
        operatorStack.push(this);
        return true;
    }

    @Override
    public void undo(NumberStack numberStack, OperatorStack operationStack) {
        if (a != null && b != null) {
            numberStack.pop();
            numberStack.push(a);
            numberStack.push(b);
            operationStack.pushUndo(this);
        }
    }

    protected abstract double calc(double a, double b);
}
