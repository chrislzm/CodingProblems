package com.chrisleung.leetcode.solutions;

public class Problem_840_Magic_Squares_In_Grid {

    public int numMagicSquaresInside(int[][] grid) {
        if(grid == null || grid.length < 3 || grid[0].length < 3) return 0;
        int numHsquares = grid[0].length - 3 + 1;
        int numVsquares = grid.length - 3 + 1;
        int ans = 0;
        for(int i=0; i<numVsquares; i++) {
            for(int j=0; j<numHsquares; j++) {
                if(isMagicSquare(i,j,grid)) ans++;
            }
        }
        return ans;
    }
    
    boolean isMagicSquare(int row, int col, int[][] grid) {
        int target = grid[row][col]+grid[row][col+1]+grid[row][col+2];
        int diag1=0, diag2=0;
        for(int k=0; k<3; k++) {
            int rowSum = 0, colSum = 0;
            for(int l=0; l<3; l++) {
                if(grid[row+k][col+l] <= 0 || grid[row+k][col+l] > 9)
                    return false;
                rowSum += grid[row+k][col+l];
                colSum += grid[row+l][col+k];
            }
            if(rowSum != target || colSum != target)
                return false;
            diag1 += grid[row+k][col+k];
            diag2 += grid[row+2-k][col+k];
        }
        if(diag1 != target || diag2 != target)
            return false;
        return true;
    }
}
