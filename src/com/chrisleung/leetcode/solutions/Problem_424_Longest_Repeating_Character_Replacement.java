package com.chrisleung.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class Problem_424_Longest_Repeating_Character_Replacement {
    
    public int characterReplacement(String s, int k) {
        if(s == null || s.isEmpty()) return 0;
        char[] str = s.toCharArray();
        Set<Character> uniqueChars = new HashSet<>();
        for(char c : str) {
            uniqueChars.add(c);
        }
        int max = 0;
        for(char c : uniqueChars) {
            int balance = 0;
            for(int winStart=0, winEnd=0; winEnd<str.length; winEnd++) {
                if(str[winEnd] != c) {
                    balance++;
                    while(balance>k) {
                        if(str[winStart] != c) {
                            balance--;
                        }
                        winStart++;
                    }
                }
                max = Math.max(winEnd-winStart+1,max);
            }
        }
        return max;
    }
    
}
