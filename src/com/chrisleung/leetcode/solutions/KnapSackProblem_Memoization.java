package com.chrisleung.leetcode.solutions;

/**
 * Problem from https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem
 * @author Chris Leung
 *
 */
public class KnapSackProblem_Memoization {
    
    static int maxValue(int availableWeight, int itemIndex, int[] itemValues, int[] itemWeights, Integer[] memo) {
        if(availableWeight == 0 || itemIndex >= itemValues.length)
            return 0;
        
        if(memo[itemIndex] == null) {
            int maxValueInclude = 0;
            int maxValueNotInclude = 0;
            
            if(itemWeights[itemIndex] <= availableWeight) {
                maxValueInclude = itemValues[itemIndex] + maxValue(availableWeight-itemWeights[itemIndex],itemIndex+1,itemValues,itemWeights,memo);
            }
            maxValueNotInclude = maxValue(availableWeight,itemIndex+1,itemValues,itemWeights,memo);
            memo[itemIndex] = Math.max(maxValueInclude, maxValueNotInclude);
        }
        return memo[itemIndex];
    }
    
    public static void main (String[] args) {
        int sackCapacity = 4; // Maximum weight capacity of knapsack
        int[] itemValues = {1,2,3};
        int[] itemWeights = {4,5,1};
        Integer[] memo = new Integer[itemValues.length];
        System.out.println(maxValue(sackCapacity,0,itemValues,itemWeights,memo));
    }
}
