package com.chrisleung.leetcode.solutions;

public class Problem_647_Palindromic_Substrings {
    
    public int countSubstrings(String s) {
        if(s == null || s.isEmpty()) return 0;
        int count = 1; // For the first character
        for(int i=1; i<s.length(); i++) {
            for(int j=0; j<=1; j++) {
                count += totalPalindromesInRange(i-j,i,s);
            }
        }
        return count;
    }
    
    private int totalPalindromesInRange(int start, int end, String s) {
        int count = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }
    
}
