package com.chrisleung.leetcode.solutions;

public class Problem_191_Number_of_1_Bits {
    public int hammingWeight(int n) {
        int ones = 0;
        while(n != 0) {
            if((n & 1) == 1)
                ones++;
            n >>>= 1;
        }
        return ones;
    }
}
