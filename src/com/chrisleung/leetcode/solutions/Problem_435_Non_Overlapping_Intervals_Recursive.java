package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

public class Problem_435_Non_Overlapping_Intervals_Recursive {
    
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals,(a,b)-> a.start != b.start ? a.start-b.start : a.end-b.end);
        return getMinRemove(0,intervals,new Integer[intervals.length]);
    }
    
    private int getMinRemove(int i, Interval[] intervals, Integer[] memo) {
        if(i >= intervals.length-1) return 0;
        if(memo[i] == null) {
            if(intervals[i].end <= intervals[i+1].start) { // No overlap with the next interval
                memo[i] = getMinRemove(i+1,intervals,memo);
            } else { // Overlaps with the next interval
                // 1. Calculate min if we keep this interval and skip all overlapping ones
                int skipToIndex = i+2;
                while(skipToIndex < intervals.length && intervals[i].end > intervals[skipToIndex].start) {
                    skipToIndex++; // While overlapping, remove interval
                }
                int numRemoved = skipToIndex - i - 1;
                int removedIfKeep = numRemoved + getMinRemove(skipToIndex,intervals,memo);
                // 2. Calculate min if we discard this interval
                int removedIfSkip = 1 + getMinRemove(i+1,intervals,memo);
                memo[i] = Math.min(removedIfKeep,removedIfSkip);
            }
        }
        return memo[i];
    }
    
}
