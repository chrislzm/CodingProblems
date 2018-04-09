package com.chrisleung.leetcode.solutions;

public class Problem_114_Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        getList(root);
    }
    
    private TreeNode getList(TreeNode n) {
        // Base case when node == null, return null
        if(n == null) {
            return null;
        }
        // Get the "list" from the left child
        TreeNode leftList = getList(n.left);
        // Get the "list" from the right child
        TreeNode rightList = getList(n.right);
        
        // Chop off the "head" of the list
        TreeNode newHead = n;
        newHead.left = null;
        newHead.right = null;
        
        // Append the root as the head of the left list
        appendLists(newHead,leftList);
        // Append the right list to the new list
        appendLists(newHead,rightList);
        // Return the list
        return newHead;        
    }

    private TreeNode appendLists(TreeNode list1, TreeNode list2) {
        if(list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        // Get the tail of list1, then set right to head of list 2
        TreeNode cur = list1;
        while(cur.right != null) {
            cur = cur.right;
        }
        cur.right = list2;
        return list1;
    }
}
