/*
 * Note: This solution uses memoization. For this problem, tabulation is faster. See v2 solution. 
 */

package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem_072_Edit_Distance {
	
	Map<String,Integer> memo = new HashMap<>();
	
    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.isEmpty()) return word2 == null ? 0 : word2.length();
        if(word2.isEmpty()) return word1.length();
        if(word1.equals(word2)) return 0;
        if(word1.length() < word2.length() ? word2.contains(word1) : word1.contains(word2))
        	return Math.abs(word1.length()-word2.length());

        String memoKey = word1 + " " + word2;
        if(memo.containsKey(memoKey)) return memo.get(memoKey);
        
        String nextWord1 = word1.substring(1);
        String nextWord2 = word2.substring(1);

        int min = Math.max(word1.length(),word2.length());

        if(word1.charAt(0) == word2.charAt(0)) {
            // Get min distance if we skip same characters
            min = Math.min(min, minDistance(nextWord1,nextWord2));
        } else {
            // Get min distance if we replace the character
            min = Math.min(min, minDistance(nextWord1,nextWord2)+1);
        }
        // Try deleting the character
        min = Math.min(min, minDistance(nextWord1,word2)+1);
        // Try inserting the character
        min = Math.min(min, minDistance(word1,nextWord2)+1);
        memo.put(memoKey,min);
        return min;
    }
}
