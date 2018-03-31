package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem_159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null) return 0;
        char[] input = s.toCharArray();
        int start = 0, maxLen = 0;
        int overallBalance = -1;
        Map<Character,Integer> charBalanceMap = new HashMap<>();
        for(int end=0; end<input.length; end++) {
            char c = input[end];
            charBalanceMap.put(c, charBalanceMap.getOrDefault(c,0)+1);
            if(charBalanceMap.get(c) == 1) {
                overallBalance++;
            }
            if(overallBalance == 1 || overallBalance == 0) {
                int curLen = end-start+1;
                maxLen = Math.max(maxLen, curLen);
            } else if(overallBalance > 1) {
                while(overallBalance > 1) {
                    char charToRemove = input[start];
                    charBalanceMap.put(charToRemove, charBalanceMap.get(charToRemove)-1);
                    if(charBalanceMap.get(charToRemove) == 0) {
                        overallBalance--;
                    }
                    start++;
                }
            }
        }
        return maxLen;
    }
}
