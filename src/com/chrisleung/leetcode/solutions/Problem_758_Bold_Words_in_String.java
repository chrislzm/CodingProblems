package com.chrisleung.leetcode.solutions;

import java.util.Arrays;

public class Problem_758_Bold_Words_in_String {

    public String boldWords(String[] words, String S) {
        if(words == null || S == null) return null;
        if(words.length == 0 || S.isEmpty()) return S;
        int sLength = S.length();
        boolean[] boldChars = new boolean[sLength];
        for(String s : words) {
            // Find all indices that the string appears in
            int startIndex = 0;
            int length = s.length();
            while(sLength - startIndex - length >= 0) {
                int foundIndex = S.indexOf(s,startIndex);
                if(foundIndex >= 0) {
                    // Mark positions at boolean array true
                    markTrue(boldChars,foundIndex,length);
                    startIndex = foundIndex+1;
                } else break;
            }
        }
        System.out.println(Arrays.toString(boldChars));
        // Go through boolean array in reverse and insert bold as needed
        StringBuilder sb = new StringBuilder(S);
        int openBracketIndex = 0;
        boolean openBracket = false;
        for(int i=sLength-1; i >= 0; i--) {
            if(boldChars[i] == true) { // Then we need to insert a </b> tag after this index
                if(!openBracket) {
                    openBracketIndex = i+1;
                    openBracket = true;
                } // Else just continue
            } else if(openBracket) {
                // "Close bracket after this index
                insertBold(sb,i+1,openBracketIndex);
                openBracket = false;
            }
        }
        if(openBracket) {
            insertBold(sb,0,openBracketIndex);
        }
        return sb.toString();
    }
    private void markTrue(boolean[] b, int start, int length) {
        for(int i=start; i<start+length; i++) {
            b[i] = true;
        }
    }
    
    private void insertBold(StringBuilder sb, int start, int end) {
        sb.insert(end,"</b>");
        sb.insert(start,"<b>");
    }
}
