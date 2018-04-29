package com.chrisleung.leetcode.solutions;

/**
 * Pratice -- converting memoization v3 into tabulation formula
 * @author Chris Leung
 *
 */
public class Problem_322_Coin_Change_Tabulation_Practice {
    
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        int[][] table = new int[coins.length+1][amount+1];
        for(int i=1; i <= amount; i++) {
            table[0][i] = -1;
        }
        for(int coinIndex=1; coinIndex <= coins.length; coinIndex++) {
            for(int change=0; change <= amount; change++) {
                int skipCoinMin = table[coinIndex-1][change];
                if(skipCoinMin < 0) skipCoinMin = Integer.MAX_VALUE;
                int useCoinRemainingChange = change-coins[coinIndex-1];
                int useCoinMin = useCoinRemainingChange >= 0 ? table[coinIndex][useCoinRemainingChange] : -1;
                useCoinMin = useCoinMin < 0 ? Integer.MAX_VALUE : useCoinMin + 1;
                int min = Math.min(skipCoinMin,useCoinMin);
                table[coinIndex][change] = min != Integer.MAX_VALUE ? min : -1;
            }
        }
        return table[coins.length][amount];
    }
    
}
