package com.chrisleung.leetcode.solutions;

public class Problem_226_Invert_Binary_Tree_Recursive {
    public TreeNode invertTree(TreeNode root) {
        if(root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
