package com.chrisleung.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class Problem_202_Happy_Number {
    public boolean isHappy(int n) {
        Set<Long> seen = new HashSet<>();
        long sum = n;
        while(sum != 1) {
            if(seen.contains(sum)) {
                return false;
            } else {
                seen.add(sum);
            }
            long newSum = 0;
            for(long i=1; sum/i>0; i*=10) {
                long digit = (sum/i)%10;
                newSum += digit*digit;
            }
            sum = newSum;
        }
        return true;
    }
}
