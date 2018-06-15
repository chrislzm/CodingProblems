package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem_212_Word_Search_II {
    
    class Trie {
        class Node {
            Map<Character,Node> children = new HashMap<>();
            boolean endWord = false;
        }
        
        Node root = new Node();
        
        void add(String s) {
            Node n = root;
            for(char c : s.toCharArray()) {
                n = n.children.computeIfAbsent(c,k->new Node());
            }
            n.endWord = true;
        }
    }
    
    int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        Trie.Node root = trie.root;
        Set<String> foundWords = new HashSet<>();
        Set<String> validWords = new HashSet<>();
        for(String word : words) {
            trie.add(word);
            validWords.add(word);
        }
        LinkedList<Character> currentWord = new LinkedList<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                findWords(board,i,j,root,foundWords, validWords, currentWord);
            }
        }
        return new ArrayList<String>(foundWords);
    }
    
    private void findWords(char[][] board, int i, int j, Trie.Node n, Set<String> foundWords, Set<String> validWords, LinkedList<Character> currentWord) {
        if(n.endWord) {
            String word = listToWord(currentWord);
            if(validWords.contains(word)) {
                foundWords.add(word);
            }
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] > 'z') return;
        Trie.Node child = n.children.get(board[i][j]);
        if(child != null) {
            for(int[] direction : directions) {
                currentWord.addLast(board[i][j]);
                board[i][j] ^= 256;
                findWords(board,i+direction[0],j+direction[1],child,foundWords,validWords,currentWord);
                board[i][j] ^= 256;
                currentWord.removeLast();
            }
        }
    }
    
    private String listToWord(LinkedList<Character> list) {
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
