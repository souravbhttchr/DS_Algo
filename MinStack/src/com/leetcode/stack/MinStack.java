package com.leetcode.stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinStack {

    private List<Integer> stack;
    private int top;
    private Stack<Integer> minStack = new Stack<>();;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayList<>();
        this.top = -1;
    }
    
    public void push(int x) {
        stack.add(x);
        ++top;
        if(minStack.isEmpty() || minStack.peek().intValue() >= x){
            minStack.push(x);
        }
    }
    
    public void pop() {
        if(top == -1){
            System.out.println("Stack empty");
        } else {
            if(stack.get(top).intValue() == minStack.peek().intValue()){
                minStack.pop();
            }
            stack.remove(top--);
        }
    }
    
    public int top() {
        return stack.get(top);
    }
    
    public int getMin() {
        return minStack.peek();
    }
}