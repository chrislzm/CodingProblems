package com.chrisleung.leetcode.solutions;

public class Problem_003_Longest_Substring_Without_Repeating_Characters {
    
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int[] freq = new int[128];
        int maxLength = 0;
        int start = 0;
        for(int end = 0; end<s.length(); end++) {
            char c1 = s.charAt(end);
            freq[c1]++;
            while(freq[c1] > 1) {
                char c2 = s.charAt(start);
                freq[c2]--;
                start++;
            }
            maxLength = Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
    
}
