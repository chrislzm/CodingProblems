package com.chrisleung.leetcode.solutions;

/* Straight forward search */
public class Problem_392_is_Subsequence_v1 {
    public boolean isSubsequence(String s, String t) {
        if(s == null || t == null || s.length() > t.length()) return false;
        if(s.isEmpty()) return true;
        int i,j;
        for(i=0,j=0; i<s.length() && j<t.length(); j++) {
            if(s.charAt(i) == t.charAt(j)) i++;
        }
        return i == s.length();
    }
}
