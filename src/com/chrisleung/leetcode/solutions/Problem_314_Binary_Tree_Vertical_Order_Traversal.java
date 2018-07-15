package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Problem_314_Binary_Tree_Vertical_Order_Traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null) return output;
        Map<Integer,List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        nodeQ.add(root);
        colQ.add(0);
        int minColIndex = 0;
        int maxColIndex = 0;
        while(!nodeQ.isEmpty()) {
            TreeNode n = nodeQ.remove();
            int colIndex = colQ.remove();
            if(!map.containsKey(colIndex)) {
                map.put(colIndex,new ArrayList<Integer>());
            }
            map.get(colIndex).add(n.val);
            if(n.left != null) {
                nodeQ.add(n.left);
                colQ.add(colIndex-1);
                minColIndex = Math.min(colIndex-1,minColIndex);
            }
            if(n.right != null) {
                nodeQ.add(n.right);
                colQ.add(colIndex+1);            
                maxColIndex = Math.max(colIndex+1,maxColIndex);
            }
        }
        for(int i=minColIndex; i<=maxColIndex; i++) {
            output.add(map.get(i));
        }
        return output;
    }
}
