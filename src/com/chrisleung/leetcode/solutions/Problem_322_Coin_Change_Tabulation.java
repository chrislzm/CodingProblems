package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

public class Problem_322_Coin_Change_Tabulation {
    public int coinChange(int[] coins, int totalAmount) {
        Arrays.sort(coins);
        Integer[][] table = new Integer[coins.length+1][totalAmount+1];
        for(int amount=0; amount<=totalAmount; amount++) {
            for(int index=1; index<=coins.length; index++) {
                int maxNumThisCoin = amount/coins[index-1];
                int min = -1;
                for(int i=maxNumThisCoin; i>=0; i--) {
                    int amountLeft = amount-i*coins[index-1];
                    int result = i;
                    if(amountLeft > 0) {
                        int numCoins = table[index-1][amountLeft];
                        if(numCoins > 0) {
                            result += numCoins;
                        } else {
                            continue;
                        }
                    } 
                    min = min >= 0 ? Math.min(min, result) : result;
                }
                table[index][amount] = min;
            }
        }
        return table[coins.length][totalAmount];
    }
}
