package com.chrisleung.leetcode.solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_v1 {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Queue<Integer> pre = new LinkedList<>();
        Queue<Integer> in = new LinkedList<>();
        for(int n : preorder) pre.add(n);
        for(int n : inorder) in.add(n);
        Set<Integer> ancestors = new HashSet<Integer>(); // If we see a value in here, it's a node we created previously
        return buildTreeHelper(pre,in,ancestors);
    }
    
    private TreeNode buildTreeHelper(Queue<Integer> preorder,Queue<Integer> inorder, Set<Integer> ancestors) {
        if(preorder.isEmpty()) return null;
        TreeNode node = new TreeNode(preorder.poll());
        ancestors.add(node.val);
        if(inorder.peek() != node.val) { // Next values are on the left side
            node.left = buildTreeHelper(preorder,inorder,ancestors);
        }
        inorder.poll(); // Must be the current node
        if(!inorder.isEmpty() && (!ancestors.contains(inorder.peek()))) { // Next values are on the right side
            node.right = buildTreeHelper(preorder,inorder,ancestors);
        }
        return node;
    }
    
}
