package com.chrisleung.other.solutions;

/**
 * Problem from https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem
 * O(n) memory solution where n is the weight
 * @author Chris Leung
 *
 */
public class KnapSackProblem_Tabulation_v3 {
    
    static int maxValue(int availableWeight, int[] itemWeight, int[] itemValue) {
        int numItems = itemWeight.length;
        int[][] table = new int[2][availableWeight+1];
        for(int item=1; item<numItems+1; item++) {
            for(int weight=1; weight<availableWeight+1; weight++) {
                table[0][weight] = table[1][weight]; // Copy previous item value to previous row
                int maxValueExclude = table[0][weight]; // Previous item
                int maxValueInclude = 0;
                if(weight >= itemWeight[item-1]) {
                    maxValueInclude = itemValue[item-1] + table[0][weight-itemWeight[item-1]];
                }
                table[1][weight] = Math.max(maxValueExclude, maxValueInclude);
            }
        }
        return table[1][availableWeight];
    }
    
    public static void main (String[] args) {
        int availableWeight = 50; // Maximum weight capacity of knapsack
        int[] itemValues = {60,100,120};
        int[] itemWeights = {10,20,30};
        System.out.println(maxValue(availableWeight,itemWeights,itemValues));
    }
}
