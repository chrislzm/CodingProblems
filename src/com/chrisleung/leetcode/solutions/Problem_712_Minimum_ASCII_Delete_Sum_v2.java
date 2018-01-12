/**
 * Same solution as Version 1 except with O(n) space where n is the length of
 * the shorter string.
 */

package com.chrisleung.leetcode.solutions;

public class Problem_712_Minimum_ASCII_Delete_Sum_v2 {
    public int minimumDeleteSum(String s1, String s2) {
    	String shorter = s1.length() > s2.length() ? s2 : s1;
    	String longer = s1.length() > s2.length() ? s1 : s2;
    	int[] cost = new int[shorter.length()+1];
        for(int j=0; j<shorter.length(); j++) {
        	cost[j+1] = shorter.charAt(j) + cost[j];
        }
        int i_j0 = 0;
    	int iMinus1_jMinus1 = 0;
        for(int i=1; i <= longer.length(); i++) {
        	i_j0 += longer.charAt(i-1);
        	int i_jMinus1 = i_j0;
        	for(int j=1; j <= shorter.length(); j++) {
    			int iMinus1_j = cost[j]; // Save previous row's value before we overwrite
        		if(shorter.charAt(j-1) == longer.charAt(i-1)) {
        			cost[j] = iMinus1_jMinus1;
        		} else {
        			cost[j] = Math.min(i_jMinus1 + shorter.charAt(j-1), iMinus1_j + longer.charAt(i-1));
        		}
        		// Setup for next loop
        		i_jMinus1 = cost[j]; 
        		iMinus1_jMinus1 = iMinus1_j;
        	}
        	 // Setup for next loop
        	iMinus1_jMinus1 = i_j0;
        }
        return cost[shorter.length()];
    }
}
