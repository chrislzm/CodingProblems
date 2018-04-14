package com.chrisleung.leetcode.solutions;

/**
 * This solution is a mess, but it works. See v2 for the elegant, faster solution.
 * @author Chris Leung
 *
 */
public class Problem_124_Binary_Tree_Maximum_Path_Sum {
    class Result {
        long maxSinglePathValue;
        long maxPrevCompletePathValue;
        Result(long x, long y) {
            maxSinglePathValue = x;
            maxPrevCompletePathValue = y;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        Result result = maxPathSumHelper(root);
        return Math.max((int)result.maxSinglePathValue,(int)result.maxPrevCompletePathValue);
    }
    
    private Result maxPathSumHelper(TreeNode n) {
        if(n == null) return new Result(Integer.MIN_VALUE,Integer.MIN_VALUE);
        Result left = maxPathSumHelper(n.left);
        Result right = maxPathSumHelper(n.right);
        
        long singePathThroughLeft = left.maxSinglePathValue+n.val;
        long singePathThroughRight = right.maxSinglePathValue+n.val;
        long maxSinglePathValue = Math.max(n.val,Math.max(singePathThroughLeft,singePathThroughRight));
        
        long pathValThruCur = Math.max(n.val,n.val+left.maxSinglePathValue+right.maxSinglePathValue);
        long maxPrevPath = Math.max(pathValThruCur,Math.max(left.maxPrevCompletePathValue,right.maxPrevCompletePathValue));
        maxPrevPath = Math.max(maxPrevPath,left.maxSinglePathValue);
        maxPrevPath = Math.max(maxPrevPath,right.maxSinglePathValue);
        return new Result(maxSinglePathValue,maxPrevPath);
    }
}
