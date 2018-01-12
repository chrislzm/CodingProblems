/**
 * Similar solution to Edit Distance but only deleting is allowed--there is no
 * replace. So we are limited in the values we can choose from, specifically,
 * when checking previous solutions, only when characters are equal at [i,j]
 * can we take the value directly [i-1,j-1], otherwise we need to choose the
 * minimum of [i-1,j] + s1[i] (delete the char from s1) and [i,j-1] + s2[j]
 * (delete the  char from s2).
 */

package com.chrisleung.leetcode.solutions;

public class Problem_712_Minimum_ASCII_Delete_Sum {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] cost = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length(); i++) {
        	cost[i+1][0] = s1.charAt(i) + cost[i][0];
        }
        for(int j=0; j<s2.length(); j++) {
        	cost[0][j+1] = s2.charAt(j) + cost[0][j];
        }
        for(int i=1; i <= s1.length(); i++) {
        	for(int j=1; j <= s2.length(); j++) {
        		if(s1.charAt(i-1) == s2.charAt(j-1)) {
        			cost[i][j] = cost[i-1][j-1];
        		} else {
        			cost[i][j] = Math.min(cost[i-1][j] + s1.charAt(i-1), cost[i][j-1] + s2.charAt(j-1));
        		}
        	}
        }
        return cost[s1.length()][s2.length()];
    }
}
