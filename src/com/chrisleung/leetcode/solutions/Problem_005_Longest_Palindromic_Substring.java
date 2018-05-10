package com.chrisleung.leetcode.solutions;

public class Problem_005_Longest_Palindromic_Substring {
    
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        int longestLength = 1;
        int longestIndex = 0;
        for(int i=1; i<s.length(); i++) {
            for(int j=0; j<=1; j++) {
                int length = longestFrom(i-j,i,s);
                if(length > longestLength) {
                    longestIndex = i - length/2;
                    longestLength = length;
                }                
            }
        }
        return s.substring(longestIndex,longestIndex+longestLength);
    }
    
    private int longestFrom(int start, int end, String s) {
        int longest = 1;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            longest = end - start + 1;
            start--;
            end++;
        }
        return longest;
    }
    
}
