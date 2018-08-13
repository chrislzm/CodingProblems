package com.chrisleung.leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_822_Card_Flipping_Game {
    public int flipgame(int[] fronts, int[] backs) {
        boolean foundDifferent = false;
        for(int i=0; i<fronts.length; i++) {
            if(fronts[i] != backs[i]) {
                foundDifferent = true;
            }
        }
        if(!foundDifferent) {
            return 0;
        }
        // Numbers are the same on front and back -- can't be those numbers
        // Numbers are different on front and back -- find the smallest of those numbers

        int[] frontCopy = Arrays.copyOf(fronts, fronts.length);
        Arrays.sort(frontCopy);
        int[] backCopy = Arrays.copyOf(backs, backs.length);
        Arrays.sort(backCopy);
        Map<Integer, Set<Integer>> frontMap = new HashMap<>();
        Map<Integer, Set<Integer>> backMap = new HashMap<>();
        for(int i=0; i<fronts.length; i++) {
            frontMap.computeIfAbsent(fronts[i], k->new HashSet<>()).add(i);
        }
        for(int i=0; i<backs.length; i++) {
            backMap.computeIfAbsent(backs[i], k->new HashSet<>()).add(i);
        }
        int frontSmallest = Integer.MAX_VALUE;
        for(int i=0; i<frontCopy.length; i++) {
            if(i > 0 && frontCopy[i] == frontCopy[i-1]) continue;
            int val = frontCopy[i];
            Set<Integer> indices = frontMap.get(val);
            Set<Integer> backIndices = backMap.get(val);
            boolean containsDuplicate = false;
            if(backIndices == null) {
                frontSmallest = val;
                break;
            }
            if(!backIndices.isEmpty()) {
                for(int j : indices) {
                    if(backIndices.contains(j)) {
                        containsDuplicate = true;
                        break;
                    }
                }
            }
            if(!containsDuplicate) {
                frontSmallest = val;
                break;
            }
        }
        
        int backSmallest = Integer.MAX_VALUE;
        for(int i=0; i<backCopy.length; i++) {
            if(i > 0 && backCopy[i] == backCopy[i-1]) continue;
            int val = backCopy[i];
            Set<Integer> indices = backMap.get(val);
            Set<Integer> frontIndicies = frontMap.get(val);
            boolean containsDuplicate = false;
            if(frontIndicies == null) {
                backSmallest = val;
                break;
            }
            if(!frontIndicies.isEmpty()) {
                for(int j : indices) {
                    if(frontIndicies.contains(j)) {
                        containsDuplicate = true;
                        break;
                    }
                }
            }
            if(!containsDuplicate) {
                backSmallest = val;
                break;
            }
        }
        int result = Math.min(frontSmallest, backSmallest);
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    
    public static void main(String[] args) {
        Problem_822_Card_Flipping_Game p = new Problem_822_Card_Flipping_Game();
        System.out.println(p.flipgame(new int[] {1,2,4,4,7}, new int[] {1,3,4,1,3}));
        System.out.println(p.flipgame(new int[] {1,1,1,1,1,2,1}, new int[] {1,1,1,1,1,1,1}));
        System.out.println(p.flipgame(new int[] {1}, new int[] {2}));
    }

}
