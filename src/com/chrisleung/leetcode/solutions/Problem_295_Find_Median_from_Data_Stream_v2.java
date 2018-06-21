package com.chrisleung.leetcode.solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_295_Find_Median_from_Data_Stream_v2 {
    
    class MedianFinder {
        
        PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder()); // Holds smaller half of numbers
        PriorityQueue<Integer> high = new PriorityQueue<>(); // Holds larger half of numbers
        
        public void addNum(int num) {
            low.add(num);
            high.add(low.remove());
            if(low.size() < high.size()) {
                low.add(high.remove());
            }
        }
        
        public double findMedian() {
            return low.size() > high.size() ? low.peek() : ((double)low.peek()+high.peek())/2;
        }
    }
}

