package com.chrisleung.leetcode.solutions;

import java.util.List;

public class Problem_841_Keys_and_Rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms,0,visited);
        for(boolean room : visited) {
            if(room == false) return false;
        }
        return true;
    }
    void dfs(List<List<Integer>> rooms, int i, boolean[] visited) {
        if(visited[i] == true) return;
        visited[i] = true;
        for(Integer roomNum : rooms.get(i)) {
            dfs(rooms,roomNum,visited);
        }
    }
}
