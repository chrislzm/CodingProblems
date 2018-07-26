package com.chrisleung.leetcode.solutions;

public class Problem_616_Add_Bold_Tag_in_String_v2 {

    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for(String substr : dict) {
            int start=0;
            while(start >= 0) {
                start = s.indexOf(substr,start);
                if(start<0) break;
                int end = start+substr.length();
                for(int i=start; i<end; i++) {
                    bold[i]=true;
                }
                start++; // Just start from next index, instead of iterating through entire string
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) { 
            if(bold[i] && (i-1<0 || !bold[i-1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i)); // Just go character by character rather than cutting up the string
            if(bold[i] && (i+1==s.length() || !bold[i+1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}
