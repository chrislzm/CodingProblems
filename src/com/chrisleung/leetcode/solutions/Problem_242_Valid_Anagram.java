package com.chrisleung.leetcode.solutions;

public class Problem_242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) return s == t;
        if(s.length() != t.length()) return false;
        int[] chars = new int[128];
        for(char c : s.toCharArray()) {
            chars[c]++;
        }
        for(char c : t.toCharArray()) {
            chars[c]--;
            if(chars[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
