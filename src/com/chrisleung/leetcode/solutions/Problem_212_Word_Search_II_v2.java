package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;


public class Problem_212_Word_Search_II_v2 {
    
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for(String s : words) {
            TrieNode n = root;
            for(char c : s.toCharArray()) {
                int i = c-'a';
                if(n.next[i] == null) {
                    n.next[i] = new TrieNode();
                }
                n = n.next[i];
            }
            n.word = s;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                findWords(board,i,j,root, result);
            }
        }
        return result;
    }
    
    private void findWords(char[][] board, int i, int j, TrieNode n, List<String> found) {
        if(n.word != null) {
            found.add(n.word);
            n.word = null; // Prevent duplicates from being found
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] > 'z') return;
        TrieNode child = n.next[board[i][j]-'a'];
        if(child != null) {
            board[i][j] ^= 256;
            for(int[] direction : directions) {
                findWords(board,i+direction[0],j+direction[1],child,found);
            }
            board[i][j] ^= 256;
        }
    }

}
