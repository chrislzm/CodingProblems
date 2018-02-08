/**
 * Though this solution was accepted, it doesn't seem to produce valid results for some test cases.
 */

package com.chrisleung.leetcode.solutions;

public class Problem_776_Split_BST {
   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }

    public TreeNode[] splitBST(TreeNode root, int v) {
        if(root == null) return new TreeNode[] {null,null};
        else if(root.left == null && root.right == null) return new TreeNode[]{root,null};
        TreeNode str = getStr(root,v);
        if(str == null) {
            return new TreeNode[]{root,null};
        }
        TreeNode parent = getParent(str, root);
        TreeNode newRoot;
        if(parent == null) { // Node is the root
            newRoot = str.right;
            root.right = null;
        } else {
            if(str == parent.left) parent.left = str.right;
            else parent.right = str.right;
            str.right = null;
            newRoot = root;
        }        
        return new TreeNode[] {newRoot,str};
    }
    
    private TreeNode getStr(TreeNode root, int v) {
        if(root == null) return null;
        if(root.val == v) return root;
        else if(root.val < v) {
            // We have a candidate, see if there's an exact value on right side
            TreeNode again = getStr(root.right, v);
            if(again == null) return root;
            else if(again.val > root.val) return again;
            else return root;
        }
        return getStr(root.left, v);        
    }

    private TreeNode getParent(TreeNode root, TreeNode cur) {
        if(cur == null) return null;
        if((cur.left != null && cur.left.val == root.val) || (cur.right != null && cur.right.val == root.val)) return cur;
        if(cur.val > root.val) return getParent(root, cur.left);
        return getParent(root, cur.right);
    }
}
