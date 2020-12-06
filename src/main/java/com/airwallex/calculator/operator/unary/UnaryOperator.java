package com.airwallex.calculator.operator.unary;

import com.airwallex.calculator.main.component.NumberStack;
import com.airwallex.calculator.main.component.OperatorStack;
import com.airwallex.calculator.main.component.RealNumber;
import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.error.ErrorMessage;

public abstract class UnaryOperator extends Operator {

    /**
     * the operation number
     */
    protected RealNumber num;

    @Override
    public boolean operate(NumberStack numberStack, OperatorStack operatorStack) {
        num = numberStack.pop();

        if (num == null) {
            this.errorMessage = ErrorMessage.INSUFFICIENT_PARAMETERS;
            return false;
        }
        numberStack.push(new RealNumber(calc(num.getValue())));
        operatorStack.push(this);
        return true;
    }

    @Override
    public void undo(NumberStack numberStack, OperatorStack operationStack) {
        if (num != null) {
            numberStack.pop();
            numberStack.push(num);
            operationStack.pushUndo(this);
        }
    }

    protected abstract double calc(double num);

}
