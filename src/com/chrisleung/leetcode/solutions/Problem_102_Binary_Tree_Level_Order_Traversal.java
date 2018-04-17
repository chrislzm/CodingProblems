package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        Queue<TreeNode> children = new LinkedList<>();
        children.add(root);
        while(!children.isEmpty()) {
            List<Integer> levelItems = new ArrayList<Integer>();
            Queue<TreeNode> parents = children;
            children = new LinkedList<>();
            for(TreeNode n : parents) {
                levelItems.add(n.val);
                if(n.left != null) {
                    children.add(n.left);
                }
                if(n.right != null) {
                    children.add(n.right);
                }
            }
            output.add(levelItems);
        }
        return output;
    }
}
