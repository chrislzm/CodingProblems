package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem_159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null) return 0;
        char[] input = s.toCharArray();
        int windowStartIndex = 0;
        int maxLength = 0;
        int overallBalance = -1; // How many distinct elements in current window. We require at least one.
        Map<Character,Integer> elementBalanceMap = new HashMap<>();
        for(int windowEndIndex=0; windowEndIndex<input.length; windowEndIndex++) {
            char element = input[windowEndIndex];
            elementBalanceMap.put(element, elementBalanceMap.getOrDefault(element,0)+1); // Increment balance for element
            if(elementBalanceMap.get(element) == 1) { // If it's a new element
                overallBalance++;
            }
            if(overallBalance == 1 || overallBalance == 0) { // If we have 1 or 2 distinct elements in the window
                int currentLength = windowEndIndex-windowStartIndex+1;
                maxLength = Math.max(maxLength, currentLength);
            } else if(overallBalance > 1) { // If we have more than 2 distinct elements in the window, we need to shrink it
                while(overallBalance > 1) {
                    char elementToRemove = input[windowStartIndex];
                    elementBalanceMap.put(elementToRemove, elementBalanceMap.get(elementToRemove)-1); // Decrement element balance
                    if(elementBalanceMap.get(elementToRemove) == 0) {
                        overallBalance--; // Decrement overall balance 
                    }
                    windowStartIndex++; // Shrink window
                }
            }
        }
        return maxLength;
    }
}
