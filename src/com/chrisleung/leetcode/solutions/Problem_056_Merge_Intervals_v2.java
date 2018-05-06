package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem_056_Merge_Intervals_v2 {

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return new ArrayList<Interval>();
        Collections.sort(intervals,(a,b)->a.start == b.start ? a.end - b.end : a.start - b.start);
        List<Interval> output = new ArrayList<>();
        Interval prev = null;
        for(Interval interval : intervals) {
            if(prev == null || interval.start > prev.end) {
                output.add(interval);
                prev = interval;
            } else if (interval.end > prev.end) { // They overlap; update if next interval end is later
                prev.end = interval.end;
            }
        }
        return output;
    }
}
