package com.chrisleung.leetcode.solutions;

public class Problem_348_Design_TicTacToe {
    class TicTacToe {

        int[] playersInRow, playersInCol, movesInRow, movesInCol, playersInDiag, movesInDiag;
        int n;

        public TicTacToe(int n) {
            playersInRow = new int[n];
            playersInCol = new int[n];
            movesInRow = new int[n];
            movesInCol = new int[n];
            playersInDiag = new int[2]; // Left diag index 0, right diag index 1
            movesInDiag = new int[2];
            this.n = n;
        }

        public int move(int row, int col, int player) {
            playersInRow[row] |= player;
            playersInCol[col] |= player;
            movesInRow[row]++;
            movesInCol[col]++;
            if(row == col) {
                movesInDiag[0]++;
                playersInDiag[0] |= player;
            }
            if(n-row-1 == col) {
                movesInDiag[1]++;
                playersInDiag[1] |= player;            
            }
            if(playersInRow[row] != 3 && movesInRow[row] == n) return playersInRow[row];
            if(playersInCol[col] != 3 && movesInCol[col] == n) return playersInCol[col];
            if(playersInDiag[0] != 3 && movesInDiag[0] == n) return playersInDiag[0];
            if(playersInDiag[1] != 3 && movesInDiag[1] == n) return playersInDiag[1];
            return 0;
        }
    }
}
