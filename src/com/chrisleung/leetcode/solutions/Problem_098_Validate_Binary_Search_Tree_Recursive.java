package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Recursive pre-order traversal
 */

public class Problem_098_Validate_Binary_Search_Tree_Recursive {
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBST(root,null,null);
    }
    
    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }
    
}
