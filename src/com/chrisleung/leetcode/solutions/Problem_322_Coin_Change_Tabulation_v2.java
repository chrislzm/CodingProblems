package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

public class Problem_322_Coin_Change_Tabulation_v2 {
    public int coinChange(int[] coins, int totalAmount) {
        Arrays.sort(coins);
        int[][] table = new int[2][totalAmount+1];
        for(int amount=0; amount<=totalAmount; amount++) {
            for(int index=1; index<=coins.length; index++) {
                table[0][amount] = table[1][amount]; // Copy to previous row
                int maxNumThisCoin = amount/coins[index-1];
                int min = -1;
                for(int i=maxNumThisCoin; i>=0; i--) {
                    int amountLeft = amount-i*coins[index-1];
                    int result = i;
                    if(amountLeft > 0) {
                        int numCoins = table[0][amountLeft];
                        if(numCoins > 0) {
                            result += numCoins;
                        } else {
                            continue;
                        }
                    } 
                    min = min >= 0 ? Math.min(min, result) : result;
                }
                table[1][amount] = min;
            }
        }
        return table[1][totalAmount];
    }
}
