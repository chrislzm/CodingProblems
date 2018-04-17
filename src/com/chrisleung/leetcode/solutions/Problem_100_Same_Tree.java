package com.chrisleung.leetcode.solutions;

public class Problem_100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) return false;
        else return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
