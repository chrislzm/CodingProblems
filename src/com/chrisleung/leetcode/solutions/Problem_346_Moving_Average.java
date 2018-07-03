package com.chrisleung.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_346_Moving_Average {
    class MovingAverage {

        int maxSize;
        long total = 0;
        Queue<Integer> q = new LinkedList<>();
        
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            maxSize = size;
        }
        
        public double next(int val) {
            total += val;
            q.add(val);
            if(q.size() > maxSize) {
                total -= q.remove();
            }
            return (double)total/q.size();
        }
    }
}
