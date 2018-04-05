package com.chrisleung.leetcode.solutions;

public class Problem_322_Coin_Change_Tabulation_v3 {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        int[] table = new int[amount+1];
        for(int i=1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;
            for(int coin : coins) {
                int remainingAmount = i - coin;
                if(remainingAmount >= 0) {
                    int result = table[remainingAmount];
                    if(result >= 0) {
                        minCoins = Math.min(minCoins,result + 1);
                    }
                }
            }
            table[i] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;         
        }
        return table[amount];
    }
}
