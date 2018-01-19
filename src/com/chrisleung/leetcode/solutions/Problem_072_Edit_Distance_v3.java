/*
 * Note: Tabulation solution, O(n) space where n is the shorter string length, O(mn) time. 
 * Based on O(mn) space solution (refer to v2)
 */

package com.chrisleung.leetcode.solutions;

public class Problem_072_Edit_Distance_v3 {
		
    public int minDistance(String word1, String word2) {
    		String shorter = word1.length() > word2.length() ? word2 : word1;
    		String longer = word1.length() > word2.length() ? word1 : word2;
    		int[] cost = new int[shorter.length()+1];
    		
    		for(int i=1; i<=shorter.length(); i++) cost[i]=i;
    		int iMinus1_jMinus1 = 0;
    		for(int j=1; j<=longer.length(); j++) {
    			cost[0] = j;
    			iMinus1_jMinus1 = j-1;
    			for(int i=1; i<=shorter.length(); i++) {
    				// Save before it gets overwritten
    				int tmp_iMinus1_jMinus1 = cost[i]; 
    				 // Skip
    				if(shorter.charAt(i-1) == longer.charAt(j-1)) cost[i]=iMinus1_jMinus1;
    				 // Replace, delete, insert
    				else cost[i] = Math.min(iMinus1_jMinus1+1, Math.min(cost[i-1]+1, cost[i]+1));
    				// Setup for next loop
    				iMinus1_jMinus1 = tmp_iMinus1_jMinus1;
    			}
    		}
    		return cost[shorter.length()];
    }
}
