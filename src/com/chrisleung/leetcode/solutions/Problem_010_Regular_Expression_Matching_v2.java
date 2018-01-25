package com.chrisleung.leetcode.solutions;
/*
 * Using an array for memo instead of nested hashmaps improves performance significantly (32ms vs 50ms on leetcode)
 */

public class Problem_010_Regular_Expression_Matching_v2 {

    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()][p.length()];
        return dfs(s,0,p,0,memo);
    }

    private boolean dfs(String s, int i, String p, int j, Boolean[][] memo) {
        if(s.length() == i && p.length() == j) return true; // End of both strings
        if(s.length() == i) { // End of first string
            if(j < p.length()-1 && p.charAt(j+1) == '*') return dfs(s,i,p,j+2,memo); // Matches if we have a *
            else return false;
        }
        if(p.length() == j) return false; // End of second string

        if(memo[i][j] != null) return memo[i][j];

        boolean result = false; // We will update to true if we find a match

        // If we can match 0 or more chars
        if(j+1 < p.length() && p.charAt(j+1) == '*') {
            int count = 0; // How many possibilities we'll iterate through
            if(p.charAt(j) == '.') count = s.length()-i; // We can match anything
            else // Otherwise count # of times this char repeats
                for(int k=i; k < s.length(); k++) {
                    if(s.charAt(k) == p.charAt(j)) count++;
                    else break;
                }
            for(int k=0; k <= count; k++) { // Try matching all possible lengths
                if(dfs(s,i+k,p,j+2,memo)) {
                    result = true;
                    break;
                }
            }
        } else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') { // If equal or matches single character
            result = dfs(s,i+1,p,j+1,memo);
        }
        
        memo[i][j] = result;
        return result;
    }
}
