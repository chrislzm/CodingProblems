package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

public class Problem_133_Clone_Graph_Recursive_DFS {
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        Map<Integer,UndirectedGraphNode> visited = new HashMap<>();
        return cloneGraph(node,visited);
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer,UndirectedGraphNode> visited) {
        if(visited.containsKey(node.label)) return visited.get(node.label);
        UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
        visited.put(clonedNode.label,clonedNode);
        for(UndirectedGraphNode neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor,visited));
        }
        return clonedNode;
    }
    
}
