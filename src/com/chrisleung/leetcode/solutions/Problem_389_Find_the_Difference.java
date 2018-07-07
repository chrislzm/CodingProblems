package com.chrisleung.leetcode.solutions;

public class Problem_389_Find_the_Difference {
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        for(char c : t.toCharArray()) letters[c-'a']++;
        for(char c : s.toCharArray()) letters[c-'a']--;
        int i=0;
        while(letters[i] != 1) i++;
        return (char)('a' + i);
    }
}
