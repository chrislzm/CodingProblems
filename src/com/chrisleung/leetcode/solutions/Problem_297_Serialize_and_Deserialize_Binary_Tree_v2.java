package com.chrisleung.leetcode.solutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Recursive approach with Queue
 * @author Chris Leung
 *
 */
public class Problem_297_Serialize_and_Deserialize_Binary_Tree_v2 {
    static final String SEPARATOR = " ";
    static final String NULL_NODE = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NULL_NODE).append(SEPARATOR);
            return;
        }
        sb.append(root.val).append(SEPARATOR);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(SEPARATOR)));
        return deserialize(q);
    }
    
    private TreeNode deserialize(Queue<String> q) {
        if(q.isEmpty()) return null;
        String s = q.poll();
        if(s.equals(NULL_NODE)) return null;
        TreeNode n = new TreeNode(Integer.parseInt(s));
        n.left = deserialize(q);
        n.right = deserialize(q);
        return n;
    }
}
