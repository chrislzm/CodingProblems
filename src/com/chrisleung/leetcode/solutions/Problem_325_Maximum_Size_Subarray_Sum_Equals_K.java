package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem_325_Maximum_Size_Subarray_Sum_Equals_K {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer,Integer> valIndexMap = new HashMap<>();
        int runningSum = 0;
        int maxLength = 0;
        for(int i=0; i<nums.length; i++) {
            runningSum += nums[i];
            if(runningSum == k) {
                maxLength = Math.max(maxLength,i+1);
            }
            if(valIndexMap.containsKey(runningSum-k)) {
                maxLength = Math.max(maxLength,i-valIndexMap.get(runningSum-k));
            }
            if(!valIndexMap.containsKey(runningSum)) {
                valIndexMap.put(runningSum,i);
            }
        }
        return maxLength;
    }
}
