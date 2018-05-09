package com.chrisleung.leetcode.solutions;

public class Problem_125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty()) return true;
        s = s.replaceAll("[^\\w]+","").toLowerCase();
        int len = s.length();
        for(int i=0; i < len/2; i++) {
            if(s.charAt(i) != s.charAt(len-1-i))
                return false;
        }
        return true;
    }
}
