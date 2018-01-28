package com.chrisleung.leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class Problem_771_Jewels_and_Stones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> j = new HashSet<>();
        for(char c : J.toCharArray()) {
            j.add(c);
        }
        int numJewels=0;
        for(char c: S.toCharArray()) {
            if(j.contains(c)) numJewels++;
        }
        return numJewels;
    }
}
