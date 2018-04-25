package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem_269_Alien_Dictionary_DFS {
    
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        Map<Character,Set<Character>> dependencies = new HashMap<Character,Set<Character>>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                dependencies.computeIfAbsent(c,k->new HashSet<Character>());
            }
        }
        buildGraph(words, 0, dependencies);
        List<Character> order = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        Set<Character> completed = new HashSet<>();
        for(char c : dependencies.keySet()) {
            if(!dfs(c,visited,completed,dependencies,order)) return "";
        }
        StringBuilder sb = new StringBuilder();
        for(char c : order) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    private boolean dfs(char c, Set<Character> visited, Set<Character> completed, Map<Character,Set<Character>> dependencies, List<Character> order) {
        if(completed.contains(c)) return true;
        if(visited.contains(c)) return false;
        visited.add(c);
        for(char dependency : dependencies.get(c)) {
            if(!dfs(dependency,visited,completed,dependencies,order)) return false;
        }
        order.add(c);
        completed.add(c);
        return true;
    }
    
    private void buildGraph(String[] words, int charIndex, Map<Character,Set<Character>> dependencies) {
        for(int i=0; i<words.length-1; i++) {
            String s1 = words[i];
            String s2 = words[i+1];
            int minLength = Math.min(s1.length(),s2.length());
            for(int j=0; j<minLength; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(c1 != c2) {
                    dependencies.get(c2).add(c1);
                    break;
                }
            }
        }
    }
}
