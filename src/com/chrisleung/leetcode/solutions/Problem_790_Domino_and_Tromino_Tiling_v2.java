/*
 *  Bottom-up solution, O(n) time, O(n) space
 */

package com.chrisleung.leetcode.solutions;

public class Problem_790_Domino_and_Tromino_Tiling_v2 {
    
    static final int MOD = 1_000_000_007;
        
    public int numTilings(int N) {
        if(N == 0) return 0;
        
        long[] dominoTilings = new long[N+1];
        dominoTilings[1] = 1;
        dominoTilings[2] = 2;
        long[] trominoTilings = new long[N+1];
        trominoTilings[1] = 0;
        trominoTilings[2] = 1;
        
        for(int i=3; i<=N; i++) {
            dominoTilings[i] = (dominoTilings[i-1] + dominoTilings[i-2] + 2 * trominoTilings[i-1]) % MOD;
            trominoTilings[i] = (dominoTilings[i-2] + trominoTilings[i-1]) % MOD;
        }
        return (int)dominoTilings[N];
    }
}
