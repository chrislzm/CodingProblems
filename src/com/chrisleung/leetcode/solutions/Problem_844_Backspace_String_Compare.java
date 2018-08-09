package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_844_Backspace_String_Compare {
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> s = new LinkedList<>();
        Deque<Character> t = new LinkedList<>();
        for(char c : S.toCharArray()) {
            if(c == '#') {
                if (!s.isEmpty()) s.pop();
            } else {
                s.push(c);
            }
        }
        for(char c : T.toCharArray()) {
            if(c == '#') {
                if(!t.isEmpty()) t.pop();
            } else {
                t.push(c);
            }
        }
        while(!s.isEmpty() && !t.isEmpty()) {
            if(s.pop() != t.pop()) return false;
        }
        return s.isEmpty() && t.isEmpty();
    }
}
