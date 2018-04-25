package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Problem_269_Alien_Dictionary_BFS {
    
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        Map<Character, Integer> numDependencies = new HashMap<>();
        Map<Character, Set<Character>> dependants = new HashMap<Character, Set<Character>>();
        /* 1. Add ALL unique elements to numDependencies  */
        for(String s: words){
            for(char c: s.toCharArray()) {
                numDependencies.put(c,0);
            }
        }
        /* 2. Build the dependency graph: Update numDependencies and dependants maps  */
        for(int i=0; i<words.length-1; i++) {
            String cur = words[i];
            String next = words[i+1];
            int minLength = Math.min(cur.length(), next.length());
            for(int j=0; j<minLength; j++) {
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1 != c2){
                    Set<Character> set = dependants.computeIfAbsent(c1,k -> new HashSet<Character>());
                    if(!set.contains(c2)) {
                        set.add(c2);
                        numDependencies.put(c2, numDependencies.get(c2)+1);
                    }
                    break;
                }
            }
        }
        /* 3. Add all elements with ZERO dependencies to the process queue  */
        Queue<Character> processQueue = new LinkedList<Character>();
        for(Map.Entry<Character,Integer> e : numDependencies.entrySet()) {
            if(e.getValue() == 0) {
                processQueue.offer(e.getKey());
            }
        }
        /* 4. Initialize output list */
        StringBuilder completedList = new StringBuilder();
        /* 5. Process each node in queue:
         *    - Add to completed list
         *    - Decrement # dependencies of each of it dependants
         *    - If # dependencies for a dependant == 0, add it to the queue */
        while(!processQueue.isEmpty()){
            char c = processQueue.poll();
            completedList.append(c);
            if(dependants.containsKey(c)) {
                for(char dependant : dependants.get(c)){
                    numDependencies.put(dependant,numDependencies.get(dependant)-1);
                    if(numDependencies.get(dependant) == 0) {
                        processQueue.add(dependant);
                    }
                }
            }
        }
        /* 6. If we did not add ALL/minimum number elements to our result, then we failed */
        if(completedList.length() != numDependencies.size()) {
            return "";
        }
        return completedList.toString();
    }
    
}
