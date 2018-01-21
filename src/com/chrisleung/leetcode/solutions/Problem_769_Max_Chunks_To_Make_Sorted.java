/**
 * Submitted as part of Leetcode Weekly Contest 68.
 * Because of competition time constraints, code will definitely not be the cleanest. :-)
 */

package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem_769_Max_Chunks_To_Make_Sorted {
    class Interval {
        int start;
        int end;
        Interval(int s, int e) {
            start = s;
            end = e;
        }
        
        @Override
        public String toString() {
            return new String("(" + start + "," + end + ")");
        }
    }

    public int maxChunksToSorted(int[] arr) {
        LinkedList<Interval> intervals = new LinkedList<>();
        for(int i=0; i<arr.length; i++) {
            int val = arr[i];
            if(val < i) {
                Interval n = new Interval(val,i);
                intervals.add(n);
            } else {
                Interval n = new Interval(i,val);
                intervals.add(n);
            }
        }
        // Reduce overlapping intervals
        List<Interval> nonOverlapping = new ArrayList<>();
        while(intervals.size() > 0) {
            Interval v = intervals.removeLast();
            Interval o = removeOverlapping(v,intervals);
            if(o != null) {
                // combine the intervals
                v.start = Math.min(v.start, o.start);
                v.end = Math.max(v.end,o.end);
                intervals.add(v);
            } else {
                nonOverlapping.add(v);
            }
        }
        return nonOverlapping.size();
    }
    
    Interval removeOverlapping(Interval v, List<Interval> intervals) {
        Iterator<Interval> i = intervals.iterator();
        while (i.hasNext()) {
            Interval m = i.next();
            if((v.start >= m.start && v.start <= m.end) || (v.end >= m.start && v.end <= m.end) || (m.start >= v.start && m.start <= v.end) || (m.end >= v.start && m.end <= v.end) ) {
                i.remove();
                return m;
            }
        }
        return null;
    }
}
