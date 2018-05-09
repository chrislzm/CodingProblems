package com.chrisleung.leetcode.solutions;

public class Problem_230_Kth_Smallest_Element_in_a_BST_Recursive {
    class Wrapper {
        int val = 0;
    }
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root,k,new Wrapper());
    }
    private Integer kthSmallestHelper(TreeNode n, int k, Wrapper num) {
        if(n == null) return null;
        Integer left = kthSmallestHelper(n.left,k,num);
        if(left != null) return left;
        if(k == ++num.val) return n.val;
        return kthSmallestHelper(n.right,k,num);
    }
}
