package com.chrisleung.leetcode.solutions;

/**
 * Dynamic programming solution -- most significant bit
 * @author Chris Leung
 */
public class Problem_338_Counting_Bits_DP_MSB {
    public int[] countBits(int num) {
        int[] bits = new int[num+1];
        for(int b=1; b<=num; b<<=1) {
            for(int x=0; x<b && x+b<=num; x++) {
                bits[x+b] = bits[x] + 1;
            }
        }
        return bits;
    }
}
