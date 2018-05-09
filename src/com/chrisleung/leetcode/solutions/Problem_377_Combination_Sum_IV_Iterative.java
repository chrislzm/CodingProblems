package com.chrisleung.leetcode.solutions;

public class Problem_377_Combination_Sum_IV_Iterative {
    public int combinationSum4(int[] nums, int target) {
        int[] table = new int[target+1];
        table[0] = 1;
        for(int remaining=1; remaining<=target; remaining++) {
            int ways = 0;
            for(int n : nums) {
                if(remaining-n >= 0) {
                    ways += table[remaining-n];
                }
            }
            table[remaining] = ways;            
        }
        return table[target];
    }
}
