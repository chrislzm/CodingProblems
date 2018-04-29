package com.chrisleung.leetcode.solutions;

public class Problem_322_Coin_Change_Memoization_v3 {
    
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        int[] table = new int[amount+1];
        for(int remaining = 1; remaining <= amount; remaining++) {
            int min = Integer.MAX_VALUE;
            for(int coinIndex=0; coinIndex < coins.length; coinIndex++) {
                int useCoinAmountRemaining = remaining-coins[coinIndex];
                if(useCoinAmountRemaining >= 0 && table[useCoinAmountRemaining] >= 0) {
                    min = Math.min(min,table[useCoinAmountRemaining]+1);
                }
            }
            table[remaining] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return table[amount];
    }

}
