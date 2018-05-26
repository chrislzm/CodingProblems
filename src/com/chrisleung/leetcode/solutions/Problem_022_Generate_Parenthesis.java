package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_022_Generate_Parenthesis {
    static final char OPEN = '(';
    static final char CLOSED = ')';
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        if(n > 0) {
            char[] str = new char[n*2];
            generateHelper(n,n,0,str,output);
        }
        return output;
    }
    
    private void generateHelper(int open, int closed, int i, char[] str, List<String> output) {
        if(open == 0 && closed == 0) {
            output.add(new String(str));
        }
        if(open > 0) {
            str[i] = OPEN;
            generateHelper(open-1,closed,i+1,str,output);
        }
        if(closed > open) {
            str[i] = CLOSED;
            generateHelper(open,closed-1,i+1,str,output);
        }
    }
}
