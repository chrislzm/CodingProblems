package com.chrisleung.leetcode.solutions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem_281_Zigzag_Iterator {
    
    public class ZigzagIterator {

        LinkedList<Iterator<Integer>> q = new LinkedList<Iterator<Integer>>();
        
        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            if(v1 != null && v1.size() > 0) q.add(v1.iterator());
            if(v2 != null && v2.size() > 0) q.add(v2.iterator());
        }

        public int next() {
            Iterator<Integer> it = q.removeFirst();
            int val = it.next();
            if(it.hasNext()) {
                q.addLast(it);
            }
            return val;
        }

        public boolean hasNext() {
            return !q.isEmpty();
        }
    }
}
