package com.chrisleung.leetcode.solutions;

public class Problem_388_Longest_Absolute_File_Path_v2 {
    public int lengthLongestPath(String s) {
        if(s == null || s.isEmpty()) return 0;
        int longest = 0;
        String[] entries = s.split("\n");
        int[] pathLength = new int[entries.length];
        for(String e : entries) {
        	int level = e.lastIndexOf('\t') + 1;
        	int length = pathLength[level] + e.length() - level;
        	pathLength[level+1] = length + 1; // Add 1 for the '/' directory slash
        	if(e.contains(".")) {
        		longest = Math.max(length, longest);
        	}
        }
        return longest;
    }
}
