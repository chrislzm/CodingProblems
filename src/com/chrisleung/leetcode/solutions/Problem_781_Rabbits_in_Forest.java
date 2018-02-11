package com.chrisleung.leetcode.solutions;

public class Problem_781_Rabbits_in_Forest {
    public int numRabbits(int[] answers) {
        Integer[] totals = new Integer[1000];
        for(int i: answers) {
            if(totals[i] == null) totals[i] = new Integer(1);
            else totals[i]++;
        }
        int ans = 0;
        if(totals[0] != null) {
            ans += totals[0];
        }
        for(int i=1; i<totals.length; i++) {
            if(totals[i] != null) {
                if(totals[i] == 1) {
                    ans += i+1;
                } else {
                    int groups = totals[i]/(i+1);
                    if(totals[i]%(i+1) > 0) groups++;
                    ans += groups * (i+1);
                }
            }
        }
        return ans;
    }
}
