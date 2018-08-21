package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchDocuments {

    HashMap<String,List<Integer>> wordToDocumentMap = new HashMap<String, List<Integer>>(); // document words : document file name map

    // Only supports up to two words separated by spaces
    List<Integer> intersection(String searchPhrase) {
        if(searchPhrase == null || searchPhrase.isEmpty()) return new ArrayList<Integer>();
        String[] words = searchPhrase.split(" ");

        String word1 = words[0];

        if(words.length == 1) {
            List<Integer> result = wordToDocumentMap.get(word1);
            if(result == null) {
                return new ArrayList<Integer>();
            }
            return new ArrayList<Integer>(result);
        }

        Set<Integer> currentMatches;

        // Deal with null case    
        Set<Integer> previousMatches = new HashSet<Integer>(wordToDocumentMap.get(words[0]));

        for(int i=1; i<words.length; i++) {
            String word = words[i];
            List<Integer> docMatches = wordToDocumentMap.get(word);
            if(docMatches != null) {
                currentMatches = new HashSet<>();
                for(Integer docId : docMatches) {
                    if(previousMatches.contains(docId)) {
                        currentMatches.add(docId);
                    }
                }
                previousMatches = currentMatches;
            }
        }

        return new ArrayList<Integer>(previousMatches);
    }
}
