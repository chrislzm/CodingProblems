package com.chrisleung.leetcode.solutions;

import java.util.HashMap;

public class Problem_211_Add_and_Search_Word {
    
    class Node {
        HashMap<Character,Node> children = new HashMap<>();
        boolean endWord = false;
    }
    
    Node root = new Node();
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node n = root;
        for(char c : word.toCharArray()) {
            if(n.children.get(c) == null) {
                n.children.put(c,new Node());
            }
            n = n.children.get(c);
        }
        n.endWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        return search(word,root,0);
    }
    
    private boolean search(String word, Node n, int i) {
        if(n == null) return false;
        if(i == word.length()) return n.endWord;
        char c = word.charAt(i);
        if(c == '.') {
            if(!n.children.keySet().isEmpty()) {
                for(char k : n.children.keySet()) {
                    if(search(word,n.children.get(k),i+1)) {
                        return true;
                    }
                }
            }
        } else {
            return search(word, n.children.get(c), i+1);
        }
        return false;
    }
}
