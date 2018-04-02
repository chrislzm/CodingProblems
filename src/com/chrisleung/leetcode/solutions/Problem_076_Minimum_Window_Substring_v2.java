package com.chrisleung.leetcode.solutions;

public class Problem_076_Minimum_Window_Substring_v2 {

    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        
        char[] input = s.toCharArray();

        // elementBalance[i]  =    # of element i that's required for a "valid" window
        // elementBalance[i] < 0  We saw element i less times than required in the current window
        // elementBalance[i] == 0 We saw element i exactly as many times as required in the current window
        // elementBalance[i] > 0  We saw element i more times than required in the current window
        // Note: We only care about elementBalance of required elements and ignore the balance of other elements that were found
        
        int[] elementBalance = new int[128];
         
        // Update balances of required elements
        for(char requiredElement : t.toCharArray()) {
            elementBalance[requiredElement]--; // Negative because we haven't found them yet
        }
                
        // Total # of required elements found in the current window
        int overallBalance = -t.length(); // Negative because we haven't found them yet
        
        // Tracks the min window found so far
        int minWindowStartIndex = 0;
        int minWindowLength = Integer.MAX_VALUE;
        
        int curWindowStartIndex = 0;
        for(int curWindowEndIndex=0; curWindowEndIndex < input.length; curWindowEndIndex++) {
            char curElement = input[curWindowEndIndex];
            elementBalance[curElement]++; 
            if(elementBalance[curElement] <= 0) {  // If we have found a required element
                overallBalance++;
            }
            // While all required elements are in the current window
            while(overallBalance == 0) { 
                // Updated minimum window found if needed
                int curWindowLength = curWindowEndIndex-curWindowStartIndex+1;
                if(curWindowLength < minWindowLength) {
                    minWindowLength = curWindowLength;
                    minWindowStartIndex = curWindowStartIndex;
                }
                // Shrink (minimize) this window size by incrementing the start index
                char elementToRemove = input[curWindowStartIndex];
                elementBalance[elementToRemove]--;
                if(elementBalance[elementToRemove] < 0) { // We've lost the minimum required# of this element
                    overallBalance--;
                }
                curWindowStartIndex++;
            }
        }
        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minWindowStartIndex,minWindowStartIndex+minWindowLength);
    }
}
