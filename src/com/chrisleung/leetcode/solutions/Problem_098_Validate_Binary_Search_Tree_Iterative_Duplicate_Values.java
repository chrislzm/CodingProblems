package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Recursive pre-order traversal
 */

public class Problem_098_Validate_Binary_Search_Tree_Iterative_Duplicate_Values {
    
    static public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        boolean onRightSideOfPrev = false;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && (prev.val > root.val || (onRightSideOfPrev && prev.val == root.val))) {
                return false;
            }
            prev = root;
            root = root.right;
            if(root != null) {
                onRightSideOfPrev = true;
            } else {
                onRightSideOfPrev = false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode leftleft = new TreeNode(5);
        TreeNode leftright = new TreeNode(8);
        TreeNode right = new TreeNode(12);
        
        root.left = left;
        left.left = leftleft;
        left.right = leftright;
        root.right = right;
        
        System.out.println(isValidBST(root));
    }
}
