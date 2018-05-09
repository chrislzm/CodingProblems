package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

public class Problem_435_Non_Overlapping_Intervals_Iterative {
    
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals,(a,b)-> a.start != b.start ? a.start-b.start : a.end-b.end);
        int[] table = new int[intervals.length+1];
        for(int i=intervals.length-2; i>=0; i--) {
            if(intervals[i].end <= intervals[i+1].start) {
                table[i] = table[i+1];
            } else {
                int skipToIndex = i+2;
                while(skipToIndex < intervals.length && intervals[i].end > intervals[skipToIndex].start) {
                    skipToIndex++; // While overlapping, remove interval
                }
                int numRemoved = skipToIndex - i - 1;
                int removedIfKeep = numRemoved + table[skipToIndex];
                int removedIfSkip = 1 + table[i+1];
                table[i] = Math.min(removedIfKeep,removedIfSkip);
            }
        }
        return table[0];
    }
    
}
