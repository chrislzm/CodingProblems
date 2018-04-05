package com.chrisleung.leetcode.solutions;

public class Problem_322_Coin_Change_Memoization_v2 {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        Integer[] memo = new Integer[amount+1];
        return minCoinHelper(coins,amount,memo);
    }
    
    private int minCoinHelper(int[] coins, int amount, Integer[] memo) {
        // For the amounts of coins remaining, iterate through possible coins, subtract the value from the total, and run the function again for the amount remaining
        // Inputs -- amount
        // Base case: amount is == 0, return 0.
        if(amount == 0) return 0;
        if(memo[amount] == null) {
            int minCoins = Integer.MAX_VALUE;
            for(int coin : coins) {
                int remainingAmount = amount - coin;
                if(remainingAmount >= 0) {
                    int result = minCoinHelper(coins,remainingAmount,memo);
                    if(result >= 0) {
                        minCoins = Math.min(minCoins,result + 1);
                    }
                }
            }
            memo[amount] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        }
        return memo[amount];
    }
}
