package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Problem_345_Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<Character>();
        for(char c : new char[] {'A','E','I','O','U','a','e','i','o','u'}) {
            vowels.add(c);
        }
        Deque<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(vowels.contains(c)) {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<sb.length(); i++) {
            if(vowels.contains(sb.charAt(i))) {
                sb.setCharAt(i,stack.pop());
            }
        }
        return sb.toString();
    }
}
