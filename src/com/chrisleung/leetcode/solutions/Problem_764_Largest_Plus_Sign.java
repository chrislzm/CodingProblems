package com.chrisleung.leetcode.solutions;

public class Problem_764_Largest_Plus_Sign {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if(mines.length >= N*N) return 0;
        // Create the array
        int[][] grid = new int[N][N];
        // Use 1 to indicate a mine
        for(int[] m : mines) grid[m[0]][m[1]] = 1;

        int largestLength = N%2 == 0 ? N-1 : N;
        // Starting with largest possible, scan through array positions
        for(; largestLength>1; largestLength -=2) {
            int offset = largestLength/2;
            for(int i=offset; i<N-offset; i++) {
                for(int j=offset; j<N-offset; j++) {
                	if(grid[i][j] == 1) continue;
                    boolean validPlacement = true;
                    for(int m=0; m<offset; m++) {
                        if(grid[i-offset+m][j] == 1 ||
                           grid[i+offset-m][j] == 1 ||
                           grid[i][j-offset+m] == 1 ||
                           grid[i][j+offset-m] == 1) {
                            validPlacement = false;
                            break;
                        }
                    }
                    if(validPlacement) return (largestLength/2 +1);
                }
            }
        }
        return 1;
    }
}
