package com.chrisleung.leetcode.solutions;

public class Problem_101_Symmetric_Tree_Recursive {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        getSubTree(left,root.left,true);
        getSubTree(right,root.right,false);
        return left.toString().equals(right.toString());
    }
    
    public void getSubTree(StringBuilder sb, TreeNode n, boolean leftFirst) {
        if(n == null) {
            sb.append('N');
            return;
        }
        sb.append(n.val);
        if(leftFirst) {
            getSubTree(sb,n.left,true);
            getSubTree(sb,n.right,true);
        } else {
            getSubTree(sb,n.right,false);
            getSubTree(sb,n.left,false);
        }
    }
}
