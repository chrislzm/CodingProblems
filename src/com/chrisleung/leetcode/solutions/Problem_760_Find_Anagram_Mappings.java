package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_760_Find_Anagram_Mappings {

	public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] p = new int[A.length];
        for(int i=0; i<B.length; i++) {
            List<Integer> l;
            if(map.containsKey(B[i])) {
                l = map.get(B[i]);
            } else {
                l = new ArrayList<>();
                map.put(B[i],l);
            }
            l.add(i);
        }
        for(int i=0; i<A.length; i++) {
        	p[i] = map.get(A[i]).remove(0);
        }
        return p;
    }
}
