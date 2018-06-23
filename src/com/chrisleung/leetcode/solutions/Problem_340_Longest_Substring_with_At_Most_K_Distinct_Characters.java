package com.chrisleung.leetcode.solutions;

public class Problem_340_Longest_Substring_with_At_Most_K_Distinct_Characters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null) return 0;
        int[] balance = new int[128];
        int winStart = 0;
        int maxLength = 0;
        int distinctChars = 0;
        for(int winEnd=0; winEnd<s.length(); winEnd++) {
            char c = s.charAt(winEnd);
            balance[c]++;
            if(balance[c] == 1) {
                distinctChars++;
            }
            while(distinctChars > k) {
                char d = s.charAt(winStart);
                balance[d]--;
                winStart++;
                if(balance[d] == 0)
                    distinctChars--;
            }
            maxLength = Math.max(maxLength,winEnd-winStart+1);
        }
        return maxLength;
    }
}
