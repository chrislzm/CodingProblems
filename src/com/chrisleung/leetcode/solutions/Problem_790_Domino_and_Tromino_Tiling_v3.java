/*
 *  Bottom-up solution, O(n) time, O(1) space
 */

package com.chrisleung.leetcode.solutions;

public class Problem_790_Domino_and_Tromino_Tiling_v3 {
    
    static final int MOD = 1_000_000_007;
        
    public int numTilings(int N) {
        if(N <= 2) return N;
        
        long domino2 = 1; // n-2
        long domino1 = 2; // n-1
        long domino = 0; // n
        
        long tromino1 = 1; // n-1
        long tromino = 0; // n
        
        for(int i=3; i<=N; i++) {
            domino = (domino1 + domino2 + 2 * tromino1) % MOD;
            tromino = (domino2 + tromino1) % MOD;
            domino2 = domino1;
            domino1 = domino;
            tromino1 = tromino;
        }
        return (int)domino;
    }
}
