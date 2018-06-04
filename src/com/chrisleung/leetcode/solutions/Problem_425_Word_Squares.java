package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_425_Word_Squares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> output = new ArrayList<List<String>>();
        Map<Character,List<String>> map = new HashMap<Character,List<String>>();
        for(String word : words) {
            char c = word.charAt(0);
            map.computeIfAbsent(c,k->new ArrayList<String>()).add(word);
        }
        for(String word : words) {
            List<String> wordSquare = new ArrayList<>();
            wordSquare.add(word);
            helper(wordSquare,word,1,output,map);
        }
        return output;
    }
    
    private void helper(List<String> ws, String s, int i, List<List<String>> output, Map<Character,List<String>> map) {
        if(i == s.length()) {
            output.add(new ArrayList<String>(ws));
            return;
        }
        List<String> words = map.get(s.charAt(i));
        if(words != null) {
            for(String w : words) {
                boolean match = true;
                for(int j=1; j<=i-1; j++) {
                    if(w.charAt(j) != ws.get(j).charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if(match) {
                    ws.add(w);
                    helper(ws,s,i+1,output,map);
                    ws.remove(ws.size()-1);
                }
            }
        }
    }
}
