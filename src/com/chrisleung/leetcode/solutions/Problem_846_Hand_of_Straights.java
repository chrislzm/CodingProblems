package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem_846_Hand_of_Straights {
    public boolean isNStraightHand(int[] hand, int W) {
        if(W == 1) return true;
        Map<Integer,Integer> freq = new HashMap<>();
        Set<Integer> s = new HashSet<>();
        for(int n : hand) {
            s.add(n);
            freq.put(n, freq.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(s);
        while(!pq.isEmpty()) {
            LinkedList<Integer> sequence = new LinkedList<>();
            for(int i=0; i<W; i++) {
                if(pq.isEmpty()) return false;
                int num = pq.poll();
                freq.put(num, freq.get(num)-1);
                if(sequence.isEmpty() || sequence.peek() == num-1) {
                    sequence.push(num);
                } else if(sequence.peek() != num-1) {
                    return false;
                }
            }
            for(int n : sequence) {
                if(freq.get(n) > 0) {
                    pq.add(n);
                }
            }
            sequence.clear();
        }
        return true;
    }
    
    public static void main(String[] args) {
        Problem_846_Hand_of_Straights p = new Problem_846_Hand_of_Straights();
        int[] a = {1,2,1,3};
        System.out.println(p.isNStraightHand(a, 2));
    }
}
