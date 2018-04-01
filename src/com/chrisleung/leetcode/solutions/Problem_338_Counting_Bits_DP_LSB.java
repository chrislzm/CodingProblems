package com.chrisleung.leetcode.solutions;

/**
 * Dynamic programming solution -- most significant bit
 * @author Chris Leung
 */
public class Problem_338_Counting_Bits_DP_LSB {
    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        for(int x=1; x<=num; x++) {
            bits[x] = bits[x>>1] + (x%2);
        }
        return bits;
    }
}
