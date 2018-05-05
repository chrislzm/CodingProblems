package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem_056_Merge_Intervals_Fast {

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return new ArrayList<Interval>();
        int numIntervals = intervals.size();
        int[] starts = new int[numIntervals];
        int[] ends = new int[numIntervals];
        for(int i=0; i<numIntervals; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> output = new ArrayList<>();
        for(int startIndex=0, endIndex=0; endIndex<numIntervals; endIndex++) {
            if(endIndex == numIntervals-1 || starts[endIndex+1] > ends[endIndex]) {
                output.add(new Interval(starts[startIndex],ends[endIndex]));
                startIndex = endIndex+1;
            }
        }
        return output;
    }
}
