package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem_010_Regular_Expression_Matching {

    Map<Integer,Map<Integer,Boolean>> memo = new HashMap<Integer,Map<Integer,Boolean>>();

    public boolean isMatch(String s, String p) {
        return dfs(s,0,p,0);
    }

    private boolean dfs(String s, int i, String p, int j) {
        if(getMemo(i,j) != null) return getMemo(i,j);
        if(s.length() == i && p.length() == j) return true;
        if(s.length() == i) {
            if(j < p.length()-1 && p.charAt(j+1) == '*') return dfs(s,i,p,j+2);
            else return false;
        }
        if(p.length() == j) return false;

        boolean result = false; // Init to false, if we find a true case, we'll update

        // If we can match 0 or more chars
        if(j+1 < p.length() && p.charAt(j+1) == '*') {
            int count = 0;
            if(p.charAt(j) == '.') count = s.length()-i; // We can match anything
            else // Otherwise count how many of this char there is
                for(int k=i; k < s.length(); k++) {
                    if(s.charAt(k) == p.charAt(j)) count++;
                    else break;
                }
            for(int k=0; k <= count; k++) { // Try matching all possible lengths
                if(dfs(s,i+k,p,j+2)) {
                    result = true;
                    break;
                }
            }
        } else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') { // If equal or matches single character
            result = dfs(s,i+1,p,j+1);
        }
        
        setMemo(i,j,result);
        return result;
    }

    private void setMemo(int i, int j, boolean result) {
        Map<Integer,Boolean> m = memo.get(i);
        if(m == null) {
            m = new HashMap<Integer,Boolean>();
            memo.put(i, m);
        }
        m.put(j, result);
    }
    
    private Boolean getMemo(int i, int j) {
        Map<Integer,Boolean> m = memo.get(i);
        if(m == null) return null;
        else return m.get(j);
    }
}
