package com.chrisleung.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_226_Invert_Binary_Tree_Iterative {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode n = q.remove();
            if(n != null) {
                TreeNode tmp = n.left;
                n.left = n.right;
                n.right = tmp;
                q.add(n.left);
                q.add(n.right);
            }
        }
        return root;
    }
}
