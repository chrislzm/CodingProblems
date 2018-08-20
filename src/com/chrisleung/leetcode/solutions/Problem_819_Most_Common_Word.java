package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_819_Most_Common_Word {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[!?',;.]","").toLowerCase();
        String[] words = paragraph.split("\\s+");
        Set<String> bannedWords = new HashSet<>();
        for(String bannedWord : banned) {
            bannedWords.add(bannedWord.toLowerCase());
        }
        Map<String,Integer> wordFreq = new HashMap<>();
        for(String word : words) {
            if(!bannedWords.contains(word)) {
                wordFreq.put(word,wordFreq.getOrDefault(word,0) + 1);
            }
        }
        int max = 0;
        String maxWord = "";
        for(Map.Entry<String,Integer> e : wordFreq.entrySet()) {
            if(max < e.getValue()) {
                max = e.getValue();
                maxWord = e.getKey();
            }
        }
        return maxWord;
    }
}
