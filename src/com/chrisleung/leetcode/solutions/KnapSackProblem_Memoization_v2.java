package com.chrisleung.leetcode.solutions;

public class KnapSackProblem_Memoization_v2 {
    
    static int maxValue(int itemIndex, int availableWeight, int[] itemWeight, int[] itemValue, Integer[][] memo) {
        if(itemIndex == 0 || availableWeight == 0) return 0;
        if(memo[itemIndex][availableWeight] == null) {
            int maxValueExclude = maxValue(itemIndex-1,availableWeight,itemWeight,itemValue,memo);
            int maxValueInclude = 0;
            if(availableWeight >= itemWeight[itemIndex-1]) {
              maxValueInclude = itemValue[itemIndex-1]
                      + maxValue(itemIndex-1,availableWeight-itemWeight[itemIndex-1],itemWeight,itemValue,memo);
            }
            memo[itemIndex][availableWeight] = Math.max(maxValueExclude,maxValueInclude);
        }
        return memo[itemIndex][availableWeight];
    }
    
    public static void main (String[] args) {
        int sackCapacity = 4; // Maximum weight capacity of knapsack
        int[] itemValues = {1,2,3};
        int[] itemWeights = {4,5,1};
        int numItems = itemValues.length;
        Integer[][] memo = new Integer[numItems+1][sackCapacity+1];
        System.out.println(maxValue(numItems,sackCapacity,itemWeights,itemValues,memo));
    }
}
