package com.chrisleung.leetcode.solutions;

import java.util.LinkedList;
import java.util.List;

public class Problem_066_Plus_One {

    public int[] plusOne(int[] digits) {
        if(digits == null) return null;
        if(digits.length == 0) return new int[0];
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 1;
        int i = digits.length-1;
        while(i >= 0) {
            int digitSum = digits[i]+carry;
            carry = digitSum/10;
            result.addFirst(digitSum%10);
            i--;
        }
        if(carry > 0) {
        	result.addFirst(carry);
        }
        return toIntArray(result);
    }
    
    int[] toIntArray(List<Integer> list)  {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list)  
            ret[i++] = e.intValue();
        return ret;
    }

}
