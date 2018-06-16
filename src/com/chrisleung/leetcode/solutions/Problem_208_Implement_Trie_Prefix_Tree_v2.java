package com.chrisleung.leetcode.solutions;

/**
 * LeetCode Problem 208 - Implement Trie (Prefix Tree)
 * @author Chris Leung
 *
 */
public class Problem_208_Implement_Trie_Prefix_Tree_v2 {
    
    static final int LETTERS = 26;
    
    class TrieNode {
        TrieNode[] child = new TrieNode[LETTERS];
        boolean endOfWord = false;
    }
    
    TrieNode root = new TrieNode();
    
    public void insert(String word) {
        if(word == null || word.length() == 0) return;
        TrieNode n = root;
        for(int i=0; i < word.length(); i++) {
            if(n.child[word.charAt(i)-'a'] == null) {
                n.child[word.charAt(i)-'a'] = new TrieNode();
            }
            n = n.child[word.charAt(i)-'a'];
        }        
        n.endOfWord = true;
    }
    
    /** Returns true if the word is in the trie. */
    public boolean search(String word) {
        TrieNode n = getLastTrieNodeOf(word);
        return n != null && n.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode n = getLastTrieNodeOf(prefix);
        return n != null;        
    }
    
    private TrieNode getLastTrieNodeOf(String word) {
        if(word == null || word.length() == 0) return null;
        TrieNode n = root;        
        for(int i=0; i<word.length(); i++) {
            if(n == null) return null;
            n = n.child[word.charAt(i)-'a'];
        }
        return n;
    }
}
