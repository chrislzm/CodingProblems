package com.chrisleung.leetcode.solutions;

/**
 * LeetCode Problem 208 - Implement Trie (Prefix Tree)
 * @author Chris Leung
 *
 */
public class Problem_208_Implement_Trie_Prefix_Tree {
    
    static final int LETTERS = 26;
    
    class TrieNode {
        char character;
        TrieNode[] child = new TrieNode[LETTERS];
        boolean endOfWord = false;
        
        TrieNode(char c) {
            character = c;
        }
    }
    
    TrieNode root = new TrieNode('\0');
    
    public void insert(String word) {
        if(word == null || word.length() == 0) return;
        char[] str = word.toCharArray();
        /* 1. Get the root node */
        int firstCharIndex = str[0] - 'a';
        TrieNode n = root.child[firstCharIndex];
        if(n == null) {
            n = new TrieNode(str[0]);
            root.child[firstCharIndex] = n;
        }
        /* 2. Get the existing substring, if any */
        int i=1;
        while(i < str.length && n.child[str[i]-'a'] != null) {
            n = n.child[str[i]-'a'];
            i++;
        }
        /* 3. Create new nodes, if needed */
        for(; i<str.length; i++) {
            int charIndex = str[i]-'a'; 
            n.child[charIndex] = new TrieNode(str[i]);
            n = n.child[charIndex];
        }
        /* 4. Complete the word */
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
        char[] str = word.toCharArray();
        int firstCharIndex = str[0] - 'a';
        TrieNode n = root.child[firstCharIndex];        
        for(int i=1; i<str.length; i++) {
            if(n == null) return null;
            n = n.child[str[i]-'a'];
        }
        return n;
    }
}
