package com.chrisleung.other.solutions;

/**
 * Problem from https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem
 * @author Chris Leung
 *
 */
public class KnapSackProblem_Tabulation_v2 {
    
    static int maxValue(int availableWeight, int[] itemWeight, int[] itemValue) {
        int numItems = itemWeight.length;
        int[][] table = new int[numItems+1][availableWeight+1];
        for(int item=1; item<numItems+1; item++) {
            for(int weight=1; weight<availableWeight+1; weight++) {
                int maxValueExclude = table[item-1][weight];
                int maxValueInclude = 0;
                if(weight >= itemWeight[item-1]) {
                    maxValueInclude = itemValue[item-1] + table[item-1][weight-itemWeight[item-1]];
                }
                table[item][weight] = Math.max(maxValueExclude, maxValueInclude);
            }
        }
        return table[numItems][availableWeight];
    }
    
    public static void main (String[] args) {
        int availableWeight = 50; // Maximum weight capacity of knapsack
        int[] itemValues = {60,100,120};
        int[] itemWeights = {10,20,30};
        System.out.println(maxValue(availableWeight,itemWeights,itemValues));
    }
}
