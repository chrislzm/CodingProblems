package com.chrisleung.leetcode.solutions;

public class Problem_387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) return -1;
        int[] freq = new int[26];
        char[] str = s.toCharArray();
        for(int i=0; i<str.length; i++) {
            freq[str[i]-'a']++;
        }
        for(int i=0; i<str.length; i++) {
            if(freq[str[i]-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
