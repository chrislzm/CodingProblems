package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_032_Longest_Valid_Parenthesis {
    public int longestValidParentheses(String s) {
        boolean[] valid = new boolean[s.length()];
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else { // ')'
                if(!stack.isEmpty()) {
                    int open = stack.pop();
                    if(i-1 == open || (valid[open+1] && valid[i-1])) {
                        valid[open] = valid[i] = true;
                    }
                }
            }
        }
        int longest=0;
        int length=0;
        for(int i=0; i<valid.length; i++) {
            if(valid[i]) length++;
            else length = 0;
            longest = Math.max(length,longest);
        }
        return longest;
    }
}
