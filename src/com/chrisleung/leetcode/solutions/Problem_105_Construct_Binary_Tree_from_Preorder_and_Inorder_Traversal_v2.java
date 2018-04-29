package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class Problem_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_v2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length) return null;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1,map);
    }

    public TreeNode build(int [] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh, Map<Integer,Integer> map) {
        if(preLow>preHigh || inLow>inHigh) return null;
        TreeNode root = new TreeNode(preorder[preLow]);

        int leftTreeSize = map.get(root.val)-inLow;

        root.left = build(preorder, preLow+1, preLow+leftTreeSize, inorder, inLow, inLow+leftTreeSize-1, map);
        root.right = build(preorder, preLow+leftTreeSize+1, preHigh, inorder, inLow+leftTreeSize+1, inHigh, map);       
        return root;
    }

}
