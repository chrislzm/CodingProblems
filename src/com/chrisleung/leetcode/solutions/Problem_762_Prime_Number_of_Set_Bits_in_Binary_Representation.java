package com.chrisleung.leetcode.solutions;

public class Problem_762_Prime_Number_of_Set_Bits_in_Binary_Representation {

    public int countPrimeSetBits(int L, int R) {
        int numPrimeBits = 0;
        for(int i=L; i<=R; i++) {
            int bits = numSetBits(i);
            if(isPrime(bits)) {
            	numPrimeBits++;
            }
        }
        return numPrimeBits;
    }
    
    private boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i <= Math.sqrt(n); i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
    
    private int numSetBits(int n) {
        int setBits = 0;
        while(n != 0) {
            if((n & 1) == 1) setBits++;
            n >>>= 1;
        }
        return setBits;
    }
    
}
