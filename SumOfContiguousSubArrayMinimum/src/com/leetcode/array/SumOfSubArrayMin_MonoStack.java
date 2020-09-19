package com.leetcode.array;

import java.util.Stack;

public class SumOfSubArrayMin_MonoStack {
	public static void main(String[] args) {
		int[] A = { 71, 55, 82, 55 };
		System.out.println(new SumOfSubArrayMin_MonoStack().sumSubarrayMins(A));
	}

	/*
    At any A[j], it could be the min of many subarrays. ex: subarray A[j] itself
    If we are able to find the previous smaller A[i] and the next smaller A[k],
    then the range from i to k has the min A[j]. Also, any subarray within this 
    range [i, k] that includes A[j] has min A[j]. For example:
    idx: 0 1 2 3 4 5 6 7
    A[]: 2 9 7 8 3 4 6 1
    if A[j] = 3
    then A[i] = 2 and A[k] = 1
    So from idx 1 to 6, inclusive, this range has min A[j] = 3
    Also, any subarray within this range that includes 3 has min 3
    
    Now, how many subarrays in [1, 6] that includes 3?
    At A[j] = 3, to its left, there are 9 7 8 3, including 3 itself.
    If we include 3 at the left, we dont have to indclude 3 at its right
    To its right there are 4 6
    
    Subarray to its left: 
    9 7 8 3
      7 8 3
        8 3
          3
          
    Subarray to its right:
    4 6
    4
    
    Now each left sub array could combine with any of the right sub arrays
    So, that 4 * 2 = 8, but dont forget the left 4 themselves also contain 3
    hence, they are also valid answers. And that is 4 * 2 + 4 or 4 * 3 = 12
    
    Or another way better to understand:
    There are 4 choices to start with: (9,7,8,3)
    There are 3 choices to end with: (3,4,6)
    
    Hence 4 * 3
    
    Now the question is how do we do this? If you know how mono stack works, easy solve
    !!!
    Keep an increasing stack, once the current A[j] is smaller than peek, pop until
    the A[j] is bigger than peek. And that is the A[i], the previous smaller
    
    Remember, once current A[j] is smaller than peek, for peek its next smaller number
    is just A[j]. So while we are poping from stack, each num we pop has next smaller
    number A[j]
    
    !!!
    */
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> stack = new Stack<>(); // used to store index but NOT numbers
        
        int sum = 0, mod = 1000000007;
        for(int k = 0; k <= A.length; k++){
            // why k <= length?
            // because if k is not equal to length, after for loop ends
            // there are still indexs left in stack
            // when k == length, making curr = 0 will for sure clear out
            // the stack except the length added in, but we dont worry that anyway
            int curr = (k == A.length ? 0 : A[k]);
            
            // if peek is bigger, pop until peek is smaller
            while(!stack.isEmpty() && A[stack.peek()] > curr){
                int j = stack.pop();
                // why -1 below? because index start at 0, at index 3, it's 4 elements
                // of distance
                int left = j - (stack.isEmpty() ? -1 : stack.peek()); 
                int right = k - j;
                sum = (sum + A[j] * left * right) % mod;
            }
            
            // if curr is bigger, add into stack
            stack.add(k);
        }
        
        // if above is not k <= length, but k < length
        // we need to keep loop in order to clear the left in stack at this point
        // while(!stack.isEmpty()){
        //         int j = stack.pop();
        //         int left = j - (stack.isEmpty() ? -1 : stack.peek());
        //         int right = A.length - j; // change k to A.length
        //         sum = (sum + A[j] * left * right) % mod;
        // }
        
        return sum;
    }
}
