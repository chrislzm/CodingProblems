package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

public class Problem_322_Coin_Change_Memoization {
    public int coinChange(int[] coins, int amount) {
        Integer[][] memo = new Integer[coins.length][amount+1];
        Arrays.sort(coins);
        return minCoins(coins, coins.length-1, amount,memo);
    }
    
    private int minCoins(int[] denominations, int index, int amount, Integer[][] memo) {
        if(index < 0) return -1;
        if(memo[index][amount] == null) {
            int maxNumThisCoin = amount/denominations[index];
            int min = -1;
            for(int i=maxNumThisCoin; i>=0; i--) {
                int amountLeft = amount-i*denominations[index];
                int result = i;
                if(amountLeft > 0) {
                    int coins = minCoins(denominations,index-1,amountLeft,memo);
                    if(coins > 0) {
                        result += coins;
                    } else {
                        continue;
                    }
                } 
                min = min >= 0 ? Math.min(min, result) : result;
            }
            memo[index][amount] = min;
        }
        return memo[index][amount];
    }
}
