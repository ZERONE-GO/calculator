package com.airwallex.calculator.operator;

import com.airwallex.calculator.main.component.NumberStack;
import com.airwallex.calculator.main.component.OperatorStack;

public abstract class Operator {

    /**
     * The message used to record the reason of operation failure.
     */
    protected String errorMessage;

    /**
     * Operators pop their parameters off the stack, and push their results back
     * onto the stack.
     * 
     * @param stack
     */
    public abstract boolean operate(NumberStack numberStack, OperatorStack operatorStack);

    /**
     * Pop up the operator result, and push the original number back onto stack accordingly.
     * 
     * @param stack
     */
    public abstract void undo(NumberStack numberStack, OperatorStack operatorStack);

    /**
     * the error message of the operation
     * 
     * @return
     */
    public String getErrorMessage() {
        return this.errorMessage;
    }

}
