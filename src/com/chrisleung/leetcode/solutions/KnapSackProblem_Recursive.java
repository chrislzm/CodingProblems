package com.chrisleung.leetcode.solutions;

/**
 * Problem from https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem
 * @author Chris Leung
 *
 */
public class KnapSackProblem_Recursive {
    
    static int maxValue(int availableWeight, int itemIndex, int[] itemValues, int[] itemWeights) {
        if(availableWeight == 0 || itemIndex >= itemValues.length)
            return 0;
        
        int maxValueInclude = 0;
        int maxValueNotInclude = 0;
        
        if(itemWeights[itemIndex] <= availableWeight) {
            maxValueInclude = itemValues[itemIndex] + maxValue(availableWeight-itemWeights[itemIndex],itemIndex+1,itemValues,itemWeights);
        }
        maxValueNotInclude = maxValue(availableWeight,itemIndex+1,itemValues,itemWeights);
        return Math.max(maxValueInclude, maxValueNotInclude);
    }
    
    public static void main (String[] args) {
        int sackCapacity = 4; // Maximum weight capacity of knapsack
        int[] itemValues = {1,2,3};
        int[] itemWeights = {4,5,1};
        System.out.println(maxValue(sackCapacity,0,itemValues,itemWeights));
    }
}
