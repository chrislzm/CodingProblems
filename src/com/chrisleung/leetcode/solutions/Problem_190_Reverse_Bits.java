package com.chrisleung.leetcode.solutions;

public class Problem_190_Reverse_Bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for(int i=0; i<32; i++) {
            result <<= 1;
            result += n&1;
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem_190_Reverse_Bits p = new Problem_190_Reverse_Bits();
        System.out.println(p.reverseBits(43261596));
    }
}
