package com.chrisleung.leetcode.solutions;

public class Problem_789_Escape_The_Ghosts {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // Calculate distance to target
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for(int[] ghost : ghosts) {
            int ghostDist = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]);
            if(ghostDist <= distance)
                return false;
        }
        return true;        
    }
    
    public static void main(String[] args) {
        Problem_789_Escape_The_Ghosts p = new Problem_789_Escape_The_Ghosts();
        System.out.println(p.escapeGhosts(new int[][] {{2, 0}}, new int[] {1,0}));
    }
}
