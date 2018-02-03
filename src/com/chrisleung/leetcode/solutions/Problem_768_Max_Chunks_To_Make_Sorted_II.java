/**
 * Submitted as part of Leetcode Weekly Contest 68.
 * Because of competition time constraints, code is definitely not be the cleanest/most optimal. :-)
 */

package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem_770_Max_Chunks_To_Make_Sorted_II {
    class Interval {
        int start;
        int end;
        Interval(int s, int e) {
            if(s < e) {
                start = s;
                end = e;                
            } else {
                start = e;
                end = s;
            }
        }
        
        @Override
        public String toString() {
            return new String("(" + start + "," + end + ")");
        }
    }

    public int maxChunksToSorted(int[] arr) {
        LinkedList<Interval> intervals = new LinkedList<>();

        // Sort the array
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
       
        // Create map Value -> List of indexes in Sorted array
        Map<Integer,LinkedList<Integer>> map = new HashMap<>();
        for(int i=0; i<sorted.length; i++) {
            LinkedList<Integer> l = map.get(sorted[i]);
            if(l == null) {
                l=new LinkedList<Integer>();
                map.put(sorted[i], l);
            }
            l.add(i);
        }
        
        // Create Intervals
        for(int i=0; i<arr.length; i++) {
            intervals.add(new Interval(i,map.get(arr[i]).removeFirst()));
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
