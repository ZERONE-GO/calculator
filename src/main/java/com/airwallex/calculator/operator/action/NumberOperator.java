package com.airwallex.calculator.operator.action;

import com.airwallex.calculator.component.NumberStack;
import com.airwallex.calculator.component.OperatorStack;
import com.airwallex.calculator.component.RealNumber;
import com.airwallex.calculator.operator.Operator;
import com.airwallex.calculator.operator.error.ErrorMessage;

public class NumberOperator extends Operator {

    /**
     * the input number
     */
    private final String numberStr;

    /**
     * the real number after convert from input number
     */
    private RealNumber number;

    public NumberOperator(String number) {
        this.numberStr = number;
    }

    @Override
    public boolean operate(NumberStack numberStack, OperatorStack operatorStack) {
        double value = 0.0;
        try {
            value = Double.parseDouble(numberStr);
        } catch (NumberFormatException e) {
            this.errorMessage = ErrorMessage.INSUFFICIENT_PARAMETERS;
            return false;
        }

        number = new RealNumber(value);
        numberStack.push(number);
        operatorStack.push(this);
        return true;
    }

    @Override
    public void undo(NumberStack numberStack, OperatorStack operatorStack) {
        numberStack.pop();
        operatorStack.pushUndo(this);
    }

}
