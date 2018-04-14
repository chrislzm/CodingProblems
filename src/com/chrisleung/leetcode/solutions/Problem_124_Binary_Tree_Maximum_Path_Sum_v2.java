package com.chrisleung.leetcode.solutions;

public class Problem_124_Binary_Tree_Maximum_Path_Sum_v2 {
    class IntegerWrapper {
        int val;
        IntegerWrapper(int v) {
            val = v;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        IntegerWrapper overallMax = new IntegerWrapper(Integer.MIN_VALUE);
        maxPathSumHelper(overallMax,root);
        return overallMax.val;
    }
    
    private int maxPathSumHelper(IntegerWrapper overallMax, TreeNode n) {
        if(n == null) return 0;
        int left = Math.max(0,maxPathSumHelper(overallMax,n.left));
        int right = Math.max(0,maxPathSumHelper(overallMax,n.right));
        int completePathValue = n.val + left + right;
        overallMax.val = Math.max(overallMax.val,completePathValue);
        return Math.max(n.val + left, n.val + right);
    }
}
