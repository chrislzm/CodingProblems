package com.chrisleung.leetcode.solutions;

public class Problem_616_Add_Bold_Tag_in_String {
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
                start++;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        for(int i=s.length()-1; i>=0; i--) {
            if(bold[i] && (i+1==s.length() || !bold[i+1])) {
                sb.insert(i+1,"</b>");
            }
            if((i-1 < 0 && bold[i]) || (i-1>=0 && !bold[i-1] && bold[i])) {
                sb.insert(i,"<b>");            
            }
        }
        return sb.toString();
    }
}
