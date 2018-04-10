package com.chrisleung.leetcode.solutions;

public class Problem_079_Word_Search {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if(word == null || word.isEmpty()) {
            return false;
        }
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(findWord(board,i,j,0,word,visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean findWord(char[][] board, int i, int j, int wordIndex, String word, boolean[][] visited) {
        if(wordIndex == word.length())
            return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length)
            return false;
        if(visited[i][j]) return false;
        char charToFind = word.charAt(wordIndex);
        if(charToFind != board[i][j]) return false;
        visited[i][j] = true;
        if(findWord(board,i+1,j,wordIndex+1,word,visited) 
           || findWord(board,i-1,j,wordIndex+1,word,visited)
           || findWord(board,i,j-1,wordIndex+1,word,visited)
           || findWord(board,i,j+1,wordIndex+1,word,visited)) {
            return true;
        }
        visited[i][j] = false; // else backtrack
        return false;
    }
}
