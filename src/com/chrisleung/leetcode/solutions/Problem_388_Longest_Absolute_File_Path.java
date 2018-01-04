package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_388_Longest_Absolute_File_Path {
    public int lengthLongestPath(String s) {
        if(s == null || s.isEmpty()) return 0;
        int longest = 0;
        int i = 0;
        int numTabs = 0;
        boolean isFile = false;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dirNameLen = new LinkedList<>();
        Deque<Integer> dirLev = new LinkedList<>();
        while(i <= s.length()) {
        	if(i == s.length() || s.charAt(i) == '\n') {
        		while(!dirLev.isEmpty() && dirLev.peek() >= numTabs) {
        			dirLev.pop();
        			dirNameLen.pop();
        		}
        		if(isFile) {
        			int length = sb.length() + numTabs;
        			length += dirNameLen.isEmpty() ? 0 : dirNameLen.peek();
        			longest = Math.max(longest, length);
        			isFile = false;
        		} else {
        			int curDirNameLen = dirNameLen.isEmpty() ? 0 : dirNameLen.peek();
        			dirNameLen.push(sb.length() + curDirNameLen);
        			dirLev.push(numTabs);
        		}
        		sb.setLength(0);
        		numTabs = 0;
        	} else {
        		char c = s.charAt(i);
        		switch(c) {
        		case '\t':
        			numTabs++;
        			break;
        		case '.':
        			isFile = true;
        			// Fall through
    			default:
    				sb.append(c);
        		}
        	}
        	i++;
        }
        return longest;
    }
}
