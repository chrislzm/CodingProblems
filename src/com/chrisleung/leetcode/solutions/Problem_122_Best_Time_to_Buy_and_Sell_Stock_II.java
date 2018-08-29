package com.chrisleung.leetcode.solutions;

public class Problem_122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int prev = Integer.MAX_VALUE;
        int totalProfit = 0;
        for(int price : prices) {
            if(price < prev) {
                prev = price;
            } else {
                totalProfit += price - prev;
                prev = price;
            }
        }
        return totalProfit;
    }
}
