package com.chrisleung.leetcode.solutions;

/**
 * Problem from https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem
 * @author Chris Leung
 *
 */
public class KnapSackProblem_Tabulation {
    
    static int maxValue(int availableWeight, int[] itemValues, int[] itemWeights) {
        int[][] table = new int[availableWeight+1][itemValues.length+1]; 
        for(int weight=0; weight<=availableWeight; weight++) {
            for(int item=0; item<=itemValues.length; item++) {
                int maxValueNotInclude = 0;
                int maxValueInclude = 0;
                if(weight!=0 && item!=0) {
                    maxValueNotInclude = table[weight][item-1];
                    maxValueInclude = 0;
                    if(weight >= itemWeights[item-1]) {
                        maxValueInclude = itemValues[item-1] + table[weight-itemWeights[item-1]][item-1];
                    } 
                }
                table[weight][item] = Math.max(maxValueNotInclude, maxValueInclude);
            }
        }
        return table[availableWeight][itemValues.length];
    }
    
    public static void main (String[] args) {
        int availableWeight = 50; // Maximum weight capacity of knapsack
        int[] itemValues = {60,100,120};
        int[] itemWeights = {10,20,30};
        System.out.println(maxValue(availableWeight,itemValues,itemWeights));
    }
}
