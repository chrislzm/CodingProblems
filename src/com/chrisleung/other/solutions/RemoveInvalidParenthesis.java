package com.chrisleung.other.solutions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Facebook technical screen problem
 * @author Chris Leung
 *
 */
public class RemoveInvalidParenthesis {
    
    // Removes unclosed parenthesis, and closed parenthesis without any opening parenthesis
    // e.g. "(()))" returns "(())". There may be other characters in the string
    
    static String removeInvalidParenthesis(String s) {
        if (s == null || s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(stack.isEmpty()) c = ' ';
                else stack.pop();
            }
            else if(c == '(') stack.push(i);
            sb.append(c);
        }
        for(int i : stack) {
            sb.setCharAt(i, ' ');
        }
        return sb.toString().replace(" ", "");
    }
    
    public static void main(String[] args) {
        System.out.println(removeInvalidParenthesis("(()))"));
        System.out.println(removeInvalidParenthesis(")("));
        System.out.println(removeInvalidParenthesis(")()("));
    }
}
