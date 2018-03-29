package com.chrisleung.leetcode.solutions;

public class Problem_076_Minimum_Window_Substring_v2 {

    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        
        char[] input = s.toCharArray();

        // elementBalance[i]  =   Minimum frequency of element i that's required for a "valid" window
        // elementBalance[i] < 0  We saw element i less times than required in the current window
        // elementBalance[i] == 0 We saw element i exactly as many times as required in the current window
        // elementBalance[i] > 0  We saw element i more times than required in the current window
        // Important: The only way charBalance[i] == 0 is if it never occurs in string t or s OR
        // we have found it exactly the required number of times. Otherwise it will always be negative.
        
        int[] elementBalance = new int[128];
         
        // Update balances of required elements
        for(char requiredElement : t.toCharArray()) {
            elementBalance[requiredElement]--;
        }
                
        // # of required elements not found in the current window
        int overallBalance = -t.length();
        
        // Tracks the min window found so far
        int minWindowStartIndex = 0;
        int minWindowLength = Integer.MAX_VALUE;
        
        int curWindowStartIndex = 0;
        for(int curWindowEndIndex=0; curWindowEndIndex < input.length; curWindowEndIndex++) {
            char curElement = input[curWindowEndIndex];
            if(elementBalance[curElement] < 0) { // If this is a required element
                overallBalance++; // We have found a required element
            }
            elementBalance[curElement]++; 
            // While all required elements are in the current window
            while(overallBalance == 0) { 
                // Updated minimum window found if needed
                int curWindowLength = curWindowEndIndex-curWindowStartIndex+1;
                if(curWindowLength < minWindowLength) {
                    minWindowLength = curWindowLength;
                    minWindowStartIndex = curWindowStartIndex;
                }
                // Shrink (minimize) this window size until we lose a required element
                char elementToRemove = input[curWindowStartIndex];
                curWindowStartIndex++;
                if(elementBalance[elementToRemove] == 0) {
                    overallBalance--; // We're losing the minimum required# of this element
                }
                elementBalance[elementToRemove]--;
            }
        }
        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minWindowStartIndex,minWindowStartIndex+minWindowLength);
    }
}
