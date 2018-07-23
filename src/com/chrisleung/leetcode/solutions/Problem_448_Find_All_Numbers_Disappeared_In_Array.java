package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_448_Find_All_Numbers_Disappeared_In_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<Integer>();
        if(nums != null && nums.length > 0) {
            for(int i=0; i<nums.length; i++) {
                int index = nums[i] < 0 ? -nums[i] - 1 : nums[i] - 1;
                if(nums[index] > 0) {
                    nums[index] = -nums[index];
                }
            }
            for(int i=0; i<nums.length; i++) {
                if(nums[i] > 0) {
                    output.add(i+1);
                }
            }
        }
        return output;
    }
}
