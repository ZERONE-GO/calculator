package com.airwallex.calculator.component;

import java.util.Stack;

import com.airwallex.calculator.operator.Operator;

public class OperatorStack {
    /**
     * the operation stack
     */
    private Stack<Operator> operatorStack;

    /**
     * the undo operation stack
     */
    private Stack<Operator> undoStack;

    /**
     * record the redo status
     */
    private boolean onRedo;

    public OperatorStack() {
        operatorStack = new Stack<>();
        undoStack = new Stack<>();
        onRedo = false;
    }

    /**
     * push the operator to the operation stack.
     * <p>
     * It will clear the undo operator stack when new operator execute.
     * </p>
     * 
     * @param operator
     */
    public void push(Operator operator) {
        operatorStack.push(operator);

        if (!onRedo && !undoStack.isEmpty()) {
            undoStack.clear();
        }
    }

    /**
     * return null when there is not operator in the stack.
     * 
     * @return
     */
    public Operator pop() {
        if (operatorStack.isEmpty()) {
            return null;
        }
        return operatorStack.pop();
    }

    /**
     * push the operator into the undo stack
     * 
     * @param operator
     */
    public void pushUndo(Operator operator) {
        undoStack.push(operator);
    }

    /**
     * return null when there is not operator in the undo stack.
     * 
     * @return
     */
    public Operator popUndo() {
        if (undoStack.isEmpty()) {
            return null;
        }
        return undoStack.pop();
    }

    /**
     * clear both operator stack and undo stack.
     */
    public void clear() {
        operatorStack.clear();
        undoStack.clear();
    }

    /**
     * when start the redo operation
     */
    public void startRedo() {
        this.onRedo = true;
    }

    /**
     * when finished the redo operation
     */
    public void closeRedo() {
        this.onRedo = false;
    }
}
