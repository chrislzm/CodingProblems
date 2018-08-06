package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.List;

public class SudokuCanSolve {

    static boolean sudokuSolve(char[][] board) {
        List<Character> candidates = null;
        int row = -1, col = -1;
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                if(board[r][c] == '.') {
                    List<Character> newCandidates = getCandidates(board,r,c);
                    if(candidates == null || newCandidates.size() < candidates.size()) {
                        candidates = newCandidates;
                        row = r;
                        col = c;
                    }
                }
            }
        }
        if(candidates == null)
            return true;

        for(Character c : candidates) {
            board[row][col] = c;
            if(sudokuSolve(board))
                return true;
        }
        board[row][col] = '.';
        return false;
    }

    static private List<Character> getCandidates(char[][] board, int row, int col) {
        List<Character> candidates = new ArrayList<>();
        for(char c : "123456789".toCharArray()) {
            boolean collision = false;
            for(int i=0; i<9; i++) {
                if(board[row][i] == c ||
                        board[i][col] == c ||
                        board[(row-row%3)+(i/3)][(col-col%3)+(i%3)] == c) {
                    collision = true;
                    break;
                }
            }
            if(!collision) {
                candidates.add(c);
            }
        }
        return candidates;
    }
    
}
