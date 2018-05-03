package com.chrisleung.leetcode.solutions;

/* Enhanced sliding window version */
public class Problem_003_Longest_Substring_Without_Repeating_Characters_v2 {
 
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int[] lastIndexAfter = new int[128]; // Store last found index after a char
        int maxLength=0;
        for(int winStart = 0, winEnd = 0; winEnd<s.length(); winEnd++) {
            char c = s.charAt(winEnd);
            winStart = Math.max(winStart, lastIndexAfter[c]);
            maxLength = Math.max(maxLength, winEnd - winStart + 1);
            lastIndexAfter[c] = winEnd+1;
        }
        return maxLength;
    }
    
}
