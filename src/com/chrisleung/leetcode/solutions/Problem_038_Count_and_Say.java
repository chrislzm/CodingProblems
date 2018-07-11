package com.chrisleung.leetcode.solutions;

public class Problem_038_Count_and_Say {
    public String countAndSay(int n) {
        String s = "1";
        for(int i=1; i<n; i++) {
            char prev = s.charAt(0);
            int count = 1;
            StringBuilder newString = new StringBuilder();
            for(int j=1; j<s.length(); j++) {
                if(s.charAt(j) == prev) {
                    count++;
                } else {
                    newString.append(count).append(prev);
                    count = 1;
                    prev = s.charAt(j);
                }
            }
            newString.append(count).append(prev);
            s = newString.toString();
            newString.setLength(0);
        }
        return s;
    }
}
