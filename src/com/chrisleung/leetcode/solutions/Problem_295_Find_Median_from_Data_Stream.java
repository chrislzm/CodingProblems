package com.chrisleung.leetcode.solutions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_295_Find_Median_from_Data_Stream {
    
    class MedianFinder {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Holds smaller half of numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Holds larger half of numbers
        int totalElements = 0;
        
        public void addNum(int num) {
            if(minHeap.isEmpty() || minHeap.peek() <= num) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
            totalElements++;
            // Balance the heaps
            int difference = minHeap.size() - maxHeap.size();
            if(difference == 2) {
                maxHeap.add(minHeap.remove());
            } else if(difference == -2) {
                minHeap.add(maxHeap.remove());
            }
        }
        
        public double findMedian() {
            if(totalElements % 2 == 0) {
                return ((double)minHeap.peek()+maxHeap.peek())/2;
            }
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }
}