package com.chrisleung.leetcode.solutions;

public class Problem_121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0) return 0;
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices) {
            minSoFar = Math.min(minSoFar, price);
            maxProfit = Math.max(maxProfit, price-minSoFar);
        }
        return maxProfit;
    }
}
