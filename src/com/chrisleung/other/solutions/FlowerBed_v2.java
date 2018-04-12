package com.chrisleung.other.solutions;

/**
 * LinkedIn technical phone screen question. Refer to version 1 for problem statement.
 * @author Chris Leung
 *
 */
public class FlowerBed_v2 {

    boolean canPlantFlowers(int[] flowerBed, int numFlowersToAdd) {
        if(numFlowersToAdd == 0) {
            return true;
        }
        if(numFlowersToAdd < 0 || flowerBed == null || flowerBed.length == 0) {
            return false;
        }
        int maxFlowersCanPlant = 0;
        int firstZeroIndex = -1; // Index of the last zero we've found
        boolean foundZero = flowerBed[0] == 0 ? true : false;
        for(int i=1; i<flowerBed.length; i++) {
            if(flowerBed[i] == 0) {
                if(!foundZero) {
                    firstZeroIndex = i;
                }
                foundZero = true;
            } else { // We found a 1
                if(foundZero) {
                    maxFlowersCanPlant += (i-firstZeroIndex-1)/2;
                }
                foundZero = false;
            }
        }
        // There are trailing zeros
        if(firstZeroIndex < flowerBed.length && flowerBed[flowerBed.length-1] == 0) {
            firstZeroIndex--;
            maxFlowersCanPlant += (flowerBed.length-firstZeroIndex-1)/2;
        }
        return maxFlowersCanPlant >= numFlowersToAdd;
    }
}
