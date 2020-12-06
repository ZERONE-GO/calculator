package com.airwallex.calculator.main.component;

import java.util.Stack;

public class NumberStack {

    private static final String HEADER = "stack:";

    private static final String WHITE_SPACE = " ";

    private Stack<RealNumber> stack;

    public NumberStack() {
        stack = new Stack<>();
    }

    /**
     * push real number into stack
     * 
     * @param num
     */
    public void push(RealNumber num) {
        stack.push(num);
    }

    /**
     * pop the real number from stack, if stack is empty, it will return null.
     * 
     * @return
     */
    public RealNumber pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.pop();
    }

    /**
     * clear the real number from the stack
     */
    public void clear() {
        stack.clear();
    }

    /**
     * convert the stack to string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder(HEADER);

        for (RealNumber num : stack) {
            builder.append(WHITE_SPACE).append(num.toString());
        }
        return builder.toString();
    }
}
