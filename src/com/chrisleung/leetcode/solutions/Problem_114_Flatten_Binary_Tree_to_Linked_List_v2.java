package com.chrisleung.leetcode.solutions;

/**
 * O(n) solution
 * @author Chris Leung
 */
public class Problem_114_Flatten_Binary_Tree_to_Linked_List_v2 {
    public void flatten(TreeNode root) {
        flatten(root,null);
    }

    private TreeNode flatten(TreeNode root, TreeNode parentRightList) {
        if(root == null) return parentRightList;
        TreeNode rightList = flatten(root.right,parentRightList);
        TreeNode leftList = flatten(root.left,rightList);
        root.right = leftList;
        root.left = null;
        return root;
    }
}
