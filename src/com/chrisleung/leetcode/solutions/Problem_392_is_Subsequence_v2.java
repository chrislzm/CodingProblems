package com.chrisleung.leetcode.solutions;

/* Use Java built-in method */
public class Problem_392_is_Subsequence_v2 {
    public boolean isSubsequence(String s, String t) {
        for(int start=0, i=0; i<s.length(); i++, start++) {
            start = t.indexOf(s.charAt(i), start);
            if(start == -1) return false;
        }
        return true;
    }
}
