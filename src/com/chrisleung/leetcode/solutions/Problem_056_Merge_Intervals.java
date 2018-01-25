package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Problem_056_Merge_Intervals {

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2) return intervals;
        Collections.sort(intervals,(a,b)->a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> output = new ArrayList<>();
        for(int i=1; i<intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if(cur.start <= end)
                end = Math.max(end,cur.end);
            else {
                output.add(new Interval(start,end));
                start = cur.start;
                end = cur.end;
            }
        }
        output.add(new Interval(start,end));
        return output;
    }
}
