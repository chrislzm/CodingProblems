package com.chrisleung.leetcode.solutions;

public class Problem_683_K_Empty_Slots {
    public int kEmptySlots(int[] flowers, int k) {
        boolean[] bloomed = new boolean[flowers.length+1];
        for(int day=0; day<flowers.length; day++) {
            int spot = flowers[day];
            for(int spot2=spot-k-1; spot2<=spot+k+1; spot2+=2*(k+1)) {
                if(spot2>=0 && spot2 < bloomed.length && bloomed[spot2]) {
                    boolean emptySpace = true;
                    for(int j=Math.min(spot,spot2)+1; j<Math.max(spot,spot2); j++) {
                        if(bloomed[j]) {
                            emptySpace=false;
                            break;
                        }
                    }
                    if(emptySpace) {
                        return day+1;
                    }
                } else {
                    bloomed[spot] = true;
                }
            }
        }
        return -1;
    }
}
