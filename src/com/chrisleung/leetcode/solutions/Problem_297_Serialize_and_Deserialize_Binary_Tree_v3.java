package com.chrisleung.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Iterative approach, BFS
 * @author Chris Leung
 *
 */
public class Problem_297_Serialize_and_Deserialize_Binary_Tree_v3 {
    static final String SEPARATOR = " ";
    static final String NULL_NODE = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode n = q.poll();
            if(n == null) {
                sb.append(NULL_NODE).append(SEPARATOR);
            } else {
                sb.append(n.val).append(SEPARATOR);
                q.offer(n.left);
                q.offer(n.right);
            }
        }
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] strings = data.split(SEPARATOR);
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        q.offer(root);
        for(int i=1; i<strings.length; i+=2) {
            TreeNode n = q.poll();
            if(!strings[i].equals(NULL_NODE)) {
                TreeNode left = new TreeNode(Integer.parseInt(strings[i]));
                n.left = left;
                q.offer(left);
            }
            if(!strings[i+1].equals(NULL_NODE)) {
                TreeNode right = new TreeNode(Integer.parseInt(strings[i+1]));
                n.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}
