package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_406_Queue_Reconstruction_by_Height_v2 {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length <= 1) return people;
        Arrays.sort(people,(a,b)->a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);
        List<int[]> output = new ArrayList<>(people.length);
        for(int[] p : people) {
            output.add(p[1],p);
        }
        return output.toArray(new int[people.length][]);
    }
}
