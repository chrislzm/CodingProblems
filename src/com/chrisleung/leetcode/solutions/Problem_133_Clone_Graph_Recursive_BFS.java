package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Problem_133_Clone_Graph_Recursive_BFS {
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        Map<Integer,UndirectedGraphNode> seen = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        seen.put(root.label,root);
        q.add(node);
        while(!q.isEmpty()) {
            node = q.poll();
            UndirectedGraphNode clonedNode = seen.get(node.label);
            for(UndirectedGraphNode neighbor : node.neighbors) {
                UndirectedGraphNode clonedNeighbor = seen.get(neighbor.label);
                if(clonedNeighbor == null) {
                    clonedNeighbor = new UndirectedGraphNode(neighbor.label);
                    seen.put(clonedNeighbor.label,clonedNeighbor);
                    q.offer(neighbor);
                }
                clonedNode.neighbors.add(clonedNeighbor);
            }
        }
        return root;
    }
    
}
