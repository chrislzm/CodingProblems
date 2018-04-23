package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Problem_207_Course_Schedule_BFS {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> dependants = new HashMap<Integer,List<Integer>>();
        Queue<Integer> processQueue = new LinkedList<Integer>();
        /* 1. Add ALL elements to the numDependencies map */
        int[] numDependencies = new int[numCourses];
        /* 2. Build the dependency graph: Update numDependencies and dependants maps  */
        for(int[] pair:prerequisites){
            numDependencies[pair[0]]++;
            dependants.computeIfAbsent(pair[1],k->new ArrayList<Integer>()).add(pair[0]);
        }
        /* 3. Add all elements with ZERO dependencies to the process queue  */
        for(int i=0;i<numDependencies.length;i++) {
            if(numDependencies[i] == 0){
                processQueue.add(i);
            }
        }
        /* 4. Initialize output list */
        int coursesCompleted = 0;
        /* 5. Process each node in queue:
         *    - Add to completed list
         *    - If has dependants
         *      - Decrement # dependencies of each of it dependants
         *      - If # dependencies for a dependant == 0, add it to the queue */
        while(!processQueue.isEmpty()) {
            int course = processQueue.poll();
            coursesCompleted++;
            if(!dependants.containsKey(course)) continue;
            for(int dependent : dependants.get(course)){
                if(--numDependencies[dependent] == 0) {
                    processQueue.add(dependent);
                }
            }
        }
        /* 6. If we did not add ALL/minimum number elements to our result, then we failed */
        if(coursesCompleted >= numCourses) {
            return true;
        }
        return false;
    }
    
}
