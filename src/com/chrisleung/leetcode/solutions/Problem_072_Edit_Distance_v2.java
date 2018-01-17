/*
 * Note: Tabulation solution, O(mn) space and time. See v3 for O(n) space where n is the shorter string length, O(mn) time. 
 */

package com.chrisleung.leetcode.solutions;

public class Problem_072_Edit_Distance_v2 {
		
    public int minDistance(String word1, String word2) {
    		int[][] cost = new int[word1.length()+1][word2.length()+1];
    		
    		for(int i=1; i<=word1.length(); i++) cost[i][0]=i;
    		for(int j=1; j<=word2.length(); j++) cost[0][j]=j;
    		
    		for(int j=1; j<=word2.length(); j++) {
    			for(int i=1; i<=word1.length(); i++) {
    				if(word1.charAt(i-1) == word2.charAt(j-1)) cost[i][j]=cost[i-1][j-1]; // Skip
    				else cost[i][j] = Math.min(cost[i-1][j-1]+1, Math.min(cost[i-1][j]+1, cost[i][j-1]+1)); // Replace, delete, insert
    			}
    		}
    		return cost[word1.length()][word2.length()];
    }
}
