package com.chrisleung.leetcode.solutions;

public class Problem_371_Sum_of_Two_Integers {
    public int getSum(int a, int b) {
        while(b != 0) {
            int carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }
}
