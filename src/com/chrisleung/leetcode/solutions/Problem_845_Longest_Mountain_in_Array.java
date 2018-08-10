package com.chrisleung.leetcode.solutions;

import java.util.LinkedList;

public class Problem_845_Longest_Mountain_in_Array {
    public int longestMountain(int[] A) {
        if(A == null) return 0;
        int max = 0;
        LinkedList<Integer> l = new LinkedList<>();
        boolean increasing = true;
        for(int i = 0; i<A.length; i++) {
            if(l.isEmpty() || (l.peek() < A[i] && increasing)) {
                l.push(A[i]);
            } else if(!l.isEmpty()){ 
                if((l.peek() < A[i] && !increasing) || l.peek() == A[i]) {
                    max = Math.max(max, l.size());
                    if(l.peek() < A[i]) {
                        int tmp = l.pop();
                        l.clear();
                        l.push(tmp);
                    } else {
                        l.clear();
                    }
                    l.push(A[i]);
                    increasing = true;
                } else if(l.peek() > A[i]) {
                    if(l.size() == 1) {
                        l.clear();
                        l.push(A[i]);
                    } else {
                        increasing = false;
                        l.push(A[i]);
                    }
                }
            }
        }
        if(!increasing) {
            max = Math.max(l.size(), max);            
        }
        return max >= 3 ? max : 0;
    }
    
    public static void main(String[] args) {
        Problem_845_Longest_Mountain_in_Array p = new Problem_845_Longest_Mountain_in_Array();
        int[] a = {2, 1, 2, 3, 4, 5, 4};
        System.out.println(p.longestMountain(a));
    }
}
