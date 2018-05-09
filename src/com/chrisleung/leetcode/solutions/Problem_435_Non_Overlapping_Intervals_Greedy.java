package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

import com.chrisleung.leetcode.solutions.Problem_768_Max_Chunks_To_Make_Sorted_II.Interval;

public class Problem_435_Non_Overlapping_Intervals_Greedy {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length ==0) return 0;
        Arrays.sort(intervals,(a,b)->a.start-b.start);
        Interval prev = intervals[0];
        int removed = 0;
        for(int i=1; i<intervals.length; i++) {
            if(prev.end > intervals[i].start) {
                prev = prev.end < intervals[i].end ? prev : intervals[i];
                removed++;
            } else {
                prev = intervals[i];
            }
        }
        return removed;
    }
}
