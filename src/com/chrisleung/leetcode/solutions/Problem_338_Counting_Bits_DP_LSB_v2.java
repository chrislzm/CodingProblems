package com.chrisleung.leetcode.solutions;

/**
 * Dynamic programming solution -- last set bit
 * @author Chris Leung
 */
public class Problem_338_Counting_Bits_DP_LSB_v2 {
    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        for(int x=1; x<=num; x++) {
            bits[x] = bits[x & x-1] + 1;
        }
        return bits;
    }
}
