package com.chrisleung.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_200_Number_of_Islands {
    
    private final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public int numIslands(char[][] grid) {
        if(grid==null) return 0;
        Queue<int[]> q = new LinkedList<>();
        int ans=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '2' || grid[i][j] == '0') continue;
                q.offer(new int[]{i,j});
                grid[i][j] = '2';
                ans++;
                while(!q.isEmpty()) {
                    int[] coord = q.poll();
                    for(int[] direction:directions) {
                        int x = coord[0]+direction[0];
                        int y = coord[1]+direction[1];
                        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '2' || grid[x][y] == '0') continue;
                        q.offer(new int[]{x,y});
                        grid[x][y] = '2';
                    }
                }
            }
        }
        return ans;
    }
}
