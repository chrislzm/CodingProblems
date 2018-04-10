package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;

public class Problem_101_Symmetric_Tree_Iterative {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        ArrayList<TreeNode> parents = new ArrayList<>();
        addChildren(root,parents);
        while(!parents.isEmpty()) {
            if(parents.size() % 2 != 0) {
                return false;
            }
            for(int i=0; i<parents.size()/2; i++) {
                TreeNode first = parents.get(i);
                TreeNode second = parents.get(parents.size()-1-i);
                if((first == null && second != null) || (first != null && second == null) || (first != null && second != null && first.val != second.val)) {
                    return false;
                }
            }
            ArrayList<TreeNode> children = new ArrayList<>();
            for(TreeNode p : parents) {
                addChildren(p,children);
            }
            parents = children;
        }
        return true;
    }
    
    private void addChildren(TreeNode n, ArrayList<TreeNode> list) {
        if(n != null) {
            list.add(n.left);
            list.add(n.right);
        }
    }
}
