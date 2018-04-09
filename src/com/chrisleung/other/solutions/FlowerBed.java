package com.chrisleung.other.solutions;

/**
 * LinkedIn technical phone screen question
 * @author Chris Leung
 *
 */
public class FlowerBed {
    // Input: [1,0,0,0,0,0,1,0,0]
    //
    //        3 => true -- Add 3 additional flowers to what's already there
    //        4 => false
    //
    // Input: [1,0,0,1,0,0,1,0,0]
    //
    //        1 => true
    //        2 => false
    // Return boolean
    // Two inputs int[] arr, int flowersToAdd
    // Example:
    // [1,0,0,0,1,0,0,0,1]
    // Special cases
    // [0, 0, 0, 0, 0]  Completely full of 0's -- of (flowers is #0's) + 1 / 2
    // [0, 0, 0, 0, 1]  Zeroes leading -- number of flowers is #0's / 2
    // [1, 0, 0, 0, 0]  Zeroes trailing -- number of flowers is #0's / 2
    // Otherwise, Consecutive odd number of zeros >= 3, # flowers we can plant are # of zeroes / 2

    // Sample input
    // [0,0,0,0,1] 2
    // [1,0,0,0,0,1] 3
    // [0] 1

    boolean canPlantFlowers(int[] flowerBed, int numFlowersToAdd) {
        if(numFlowersToAdd == 0) {
            return true;
        }
        if(numFlowersToAdd < 0 || flowerBed == null || flowerBed.length == 0) {
            return false;
        }
        int maxFlowersCanPlant = 0;
        int firstZeroIndex = -1; // Index of the last zero we've found
        for(int i=0; i<flowerBed.length; i++) { // 0, 1, 2, 3, 4, 5
            if(flowerBed[i] == 0 && firstZeroIndex < 0) {
                firstZeroIndex = i; // 1
            } else { // We found a 1
                // See how many zeros we have and increment number of flowers we can plant
                if(firstZeroIndex == 0) { // Special case (leading zeros)
                    maxFlowersCanPlant = i/2; 
                } else if(firstZeroIndex > 0) {
                    int numConsecutiveZeros = i-firstZeroIndex;
                    maxFlowersCanPlant += (numConsecutiveZeros-1)/2; // 1
                }
                firstZeroIndex = -1;
            }
        }
        // There are trailing zeros
        if(firstZeroIndex < flowerBed.length && flowerBed[flowerBed.length-1] == 0) {
            if(firstZeroIndex == -1) {
                // We never encountered a 1 in the array
                maxFlowersCanPlant = flowerBed.length % 2 == 0 ? flowerBed.length/2 : (flowerBed.length+1) / 2;
            } else {
                int numTrailingZeros = flowerBed.length-firstZeroIndex;
                maxFlowersCanPlant += flowerBed.length == 1 ? 1 : numTrailingZeros/2;
            }
        }
        return maxFlowersCanPlant >= numFlowersToAdd;
    }
}
