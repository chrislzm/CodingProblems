package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_271_Encode_and_Decode_Strings {
    static final char EMPTY_STRING = (char)258;
    static final char END_STRING = (char)257;
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null || strs.size() == 0) return null;
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            if(s.isEmpty()) {
                sb.append(EMPTY_STRING);
            } else {
                sb.append(s);
            }
            sb.append(END_STRING);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> output =  new ArrayList<String>();
        if(s != null) {
            String[] strs = s.split(String.valueOf(END_STRING));
            for(String str : strs) {
                if(str.charAt(0) == EMPTY_STRING) {
                    output.add("");
                } else {
                    output.add(str);
                }
            }
        }
        return output;
    }
}
