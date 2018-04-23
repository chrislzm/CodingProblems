package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem_207_Course_Schedule_DFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> edges = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> completed = new HashSet<>();
        for(int[] p : prerequisites) {
            edges.computeIfAbsent(p[0],k->new ArrayList<Integer>()).add(p[1]);
        }
        for(int course = 0; course<numCourses; course++) {
            dfs(course,edges,visited,completed);
            if(completed.size() >= numCourses) return true;
        }
        return false;
    }
    
    private boolean dfs(int course, Map<Integer,List<Integer>> edges,Set<Integer> visited,Set<Integer> completed) {
        if(completed.contains(course)) return true;
        if(visited.contains(course)) return false;
        if(edges.containsKey(course)) { // No prerequisites
            visited.add(course);
            for(int prereq : edges.get(course)) {
                if(!dfs(prereq,edges,visited,completed)) return false; // Cycle, can't complete this course
            }
        }
        completed.add(course);
        return true;
    }
}
