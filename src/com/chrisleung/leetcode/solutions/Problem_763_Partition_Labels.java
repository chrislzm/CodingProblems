package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_763_Partition_Labels {
	
    class Interval {
        int i,j, count;
        
        Interval(int m) {
            i=j=m;
        }
        void updateEnd(int n) {
            j=n;
        }
    }
    
    public List<Integer> partitionLabels(String S) {
        Map<Character,Interval> m = new HashMap<>();
        // Make intervals
        for(int i=0; i<S.length(); i++) {
            Interval interval;
            char c = S.charAt(i);
            if(m.containsKey(c)) {
                interval = m.get(c);
                interval.updateEnd(i);
            } else {
                interval = new Interval(i);
                m.put(c,interval);
            }
        }

        // Sort intervals
        List<Interval> intervals = new ArrayList<>(m.values());
        Collections.sort(intervals, (a,b)->a.i-b.i);
        
        // Find length of each interval where no other interval overlaps        
        List<Integer> output = new ArrayList<>();
        int prevIntervalStart = 0;
        int prevIntervalEnd = 0;
        for(Interval interval : intervals) {
            if(interval.i > prevIntervalEnd) {
                output.add(interval.i-prevIntervalStart);
                prevIntervalStart = interval.i;
                prevIntervalEnd = interval.j;
            } else {
                prevIntervalEnd = Math.max(interval.j,prevIntervalEnd);
            }
        }
        // Add last interval
        output.add(S.length()-prevIntervalStart);
        return output;
    }
}
