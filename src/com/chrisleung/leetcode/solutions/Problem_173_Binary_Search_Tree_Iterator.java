package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class BSTIterator {
    Deque<TreeNode> stack = new LinkedList<>();
    
    public BSTIterator(TreeNode root) {
        getMin(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode n = stack.pop();
        getMin(n.right);
        return n.val;
    }
    
    private void getMin(TreeNode n) {
        while(n != null) {
            stack.push(n);
            n = n.left;
        }
    }
}
