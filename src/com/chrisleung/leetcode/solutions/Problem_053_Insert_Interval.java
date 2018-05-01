package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_053_Insert_Interval {
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || intervals.size()==0) return new ArrayList<>(Arrays.asList(newInterval));
        List<Interval> output = new ArrayList<>();
        int i=0;
        int size=intervals.size();
        // 1. Add all intervals before the new interval
        for(; i<size && intervals.get(i).end < newInterval.start; i++) {
            output.add(intervals.get(i));
        }
        // 2. Merge any overlapping intervals
        for(; i<size && intervals.get(i).start <= newInterval.end; i++) {
            newInterval.start = Math.min(intervals.get(i).start,newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end,newInterval.end);
        }
        // 3. Add the new interval
        output.add(newInterval);
        // 4. Add any remaining intervals
        output.addAll(intervals.subList(i,intervals.size()));
        return output;
    }
    
}
