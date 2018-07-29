package com.chrisleung.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

/* Faster method with Tries */
public class Problem_720_Longest_Word_in_Dictionary_v2 {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public String longestWord(String[] words) {
        String longest = "";
        TrieNode root = new TrieNode();
        root.word = longest;
        for(String word : words) {
            TrieNode node = root;        
            for(char c : word.toCharArray()) {
                if(node.next[c-'a'] == null)
                    node.next[c-'a'] = new TrieNode();
                node = node.next[c-'a'];
            }
            node.word = word;
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TrieNode node = q.poll();
            if(node.word != null) {
                if(node.word.length() > longest.length() || (node.word.length() == longest.length() && longest.compareTo(node.word) > 0))
                    longest = node.word;
                for(int i=0; i<26; i++)
                    if(node.next[i] != null)
                        q.add(node.next[i]);
            }
        }
        return longest;
    }
}
