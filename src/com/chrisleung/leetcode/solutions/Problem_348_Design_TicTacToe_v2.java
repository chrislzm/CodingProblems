package com.chrisleung.leetcode.solutions;

public class Problem_348_Design_TicTacToe_v2 {
    
    class TicTacToe {

        int[] rows, cols;
        int leftDiag, rightDiag;
        int n;

        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
            this.n = n;
        }

        public int move(int row, int col, int player) {
            int moveVal = player == 1 ? 1 : -1;
            int target = moveVal * n;
            rows[row] += moveVal;
            cols[col] += moveVal;
            if(row == col)
                leftDiag += moveVal;
            if(n-row-1 == col)
                rightDiag += moveVal;
            if(rows[row] == target || cols[col] == target || leftDiag == target || rightDiag == target)
                return player;
            return 0;
        }
    }
    
}
