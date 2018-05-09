package com.chrisleung.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class Problem_128_Longest_Consecutive_Sequence_v2 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        Set<Integer> s = new HashSet<>();
        for(int n : nums) {
            s.add(n);
        }
        int max = 0;
        for(int n : nums) {
            s.remove(n);
            int count = 1;
            int left=n-1;
            int right=n+1;
            while(s.contains(left)) {
                s.remove(left);
                left--;
                count++;
            }
            while(s.contains(right)) {
                s.remove(right);
                right++;
                count++;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}
