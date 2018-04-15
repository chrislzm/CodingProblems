package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Iterative in-order traversal
 * IMPORTANT: Does not support duplicate values in the tree
 */

public class Problem_098_Validate_Binary_Search_Tree_Iterative {
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode previous = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(previous != null && previous.val >= root.val) {
                return false;
            }
            previous = root;
            root = root.right;
        }
        return true;
    }
    
}
