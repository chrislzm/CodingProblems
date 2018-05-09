package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

import com.chrisleung.leetcode.solutions.Problem_769_Max_Chunks_To_Make_Sorted.Interval;

public class Problem_252_Meeting_Rooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals,(a,b)->a.start-b.start);
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i-1].end > intervals[i].start)
                return false;
        }
        return true;
    }
}
