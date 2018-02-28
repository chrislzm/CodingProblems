package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem_790_Domino_and_Tromino_Tiling {
    
    static final int MOD = 1_000_000_007;
    Map<Integer,Integer> dominoMemo = new HashMap<>();
    Map<Integer,Integer> trominoMemo = new HashMap<>();
        
    public int numTilings(int N) {
        if(N == 0) return 0;
        return (int) dominoTilings(N);
    }

    private long dominoTilings(int N) {
        if(N == 1) return 1;
        if(N == 2) return 2;
        if(!dominoMemo.containsKey(N)) {
            long result = (dominoTilings(N-1) + dominoTilings(N-2) + 2 * trominoTilings(N-1)) % MOD;
            dominoMemo.put(N, (int)result);
        }
        return dominoMemo.get(N);
    }

    private long trominoTilings(int N) {
        if(N == 1) return 0;
        if(N == 2) return 1;
        if(!trominoMemo.containsKey(N)) {
            long result = (dominoTilings(N-2) + trominoTilings(N-1)) % MOD;
            trominoMemo.put(N, (int)result);
        }
        return trominoMemo.get(N);
    }
}
