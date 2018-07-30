package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.LinkedList;

/* Approach 2: Stack */
public class Problem_739_Daily_Temperatures_v2 {
    
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] output = new int[temperatures.length];
        for(int i=temperatures.length-1; i>=0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                output[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return output;
    }
    
}
