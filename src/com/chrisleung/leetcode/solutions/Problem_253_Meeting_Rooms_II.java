package com.chrisleung.leetcode.solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.chrisleung.leetcode.solutions.Problem_769_Max_Chunks_To_Make_Sorted.Interval;

public class Problem_253_Meeting_Rooms_II {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals,(a,b)->a.start-b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->a.end-b.end);
        pq.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i].start >= pq.peek().end) {
                pq.poll();
            }
            pq.offer(intervals[i]);
        }
        return pq.size();
    }
}
