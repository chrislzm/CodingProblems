package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Simply traverse the tree in order and convert to a list, then track the difference between adjacent elements.
 * @author Chris Leung
 */
public class Problem_783_Minimum_Distance_Between_BST_Nodes {
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    public int minDiffInBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        dfs(root,l);
        int prev = l.get(0);
        int minDiff = Integer.MAX_VALUE;
        for(int i=1; i<l.size(); i++) {
            minDiff = Math.min(minDiff, l.get(i)-prev);
            prev = l.get(i);
        }
        return minDiff;
    }
    
    private void dfs(TreeNode root, List<Integer> l) {
        if(root == null) return;
        dfs(root.left,l);
        l.add(root.val);
        dfs(root.right,l);
    }
}
