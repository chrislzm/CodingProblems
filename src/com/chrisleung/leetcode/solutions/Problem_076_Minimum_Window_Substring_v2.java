package com.chrisleung.leetcode.solutions;

public class Problem_076_Minimum_Window_Substring_v2 {
    public String minWindow(String s, String t) {
        int[] charFreq = new int[128];
        for(char c : t.toCharArray()) {
            charFreq[c]++;
        }
        int balance = t.length();
        int windowStartIndex = 0;
        int windowEndIndex = 0;
        int minWindowLen = Integer.MAX_VALUE;
        int minWindowStartIndex = 0;
        char[] str = s.toCharArray();
        while(windowEndIndex < str.length) {
            char c = str[windowEndIndex];
            if(charFreq[c] > 0)
                balance--;
            charFreq[c]--;
            while(balance == 0) {
                int curWindowLength = windowEndIndex+1-windowStartIndex;
                if(curWindowLength < minWindowLen) {
                    minWindowLen = curWindowLength;
                    minWindowStartIndex = windowStartIndex;
                }
                char firstWindowChar = str[windowStartIndex];
                if(charFreq[firstWindowChar] == 0) {
                    balance++;
                }
                charFreq[firstWindowChar]++;
                windowStartIndex++;
            }
            windowEndIndex++;
        }
        return minWindowLen == Integer.MAX_VALUE ? "" : s.substring(minWindowStartIndex,minWindowStartIndex+minWindowLen);
    }
}
