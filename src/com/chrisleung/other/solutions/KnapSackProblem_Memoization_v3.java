package com.chrisleung.other.solutions;

public class KnapSackProblem_Memoization_v3 {
    static int maxValue(int availableWeight, int startIndex, int[] itemWeights, int[] itemValues, Integer[] memo) {
        if(availableWeight == 0 || startIndex > itemWeights.length) return 0;
        if(memo[availableWeight]==null) { 
            int max = 0;
            for(int i=startIndex; i<itemWeights.length; i++) {
                int newWeight = availableWeight - itemWeights[i];
                if(newWeight>=0) {
                    max = Math.max(max, itemValues[i] + maxValue(newWeight, i+1, itemWeights,itemValues,memo));
                }
            }
            memo[availableWeight] = max;
        }
        return memo[availableWeight];
    }
    
    public static void main (String[] args) {
        int sackCapacity = 50; // Maximum weight capacity of knapsack
        int[] itemValues = {60,100,120};
        int[] itemWeights = {10,20,30};
        Integer[] memo = new Integer[sackCapacity+1];
        System.out.println(maxValue(sackCapacity,0,itemWeights,itemValues,memo));
    }
}
