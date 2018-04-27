package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time limit exceeded. See version 2 for better solution.
 * @author Chris Leung
 *
 */
public class Problem_297_Serialize_and_Deserialize_Binary_Tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            String comma = "";
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            boolean nextLevelHasNode = true;
            while(nextLevelHasNode) {
                nextLevelHasNode = false;
                Queue<TreeNode> nextLevelq = new LinkedList<>();
                for(TreeNode n : q) {
                    sb.append(comma);
                    if(n == null) {
                        nextLevelq.add(null);
                        nextLevelq.add(null);
                        sb.append("null");
                    } else {
                        sb.append(n.val);
                        nextLevelq.add(n.left);
                        nextLevelq.add(n.right);
                        nextLevelHasNode = nextLevelHasNode || (n.left != null) || (n.right != null);
                    }
                    comma = ",";
                }
                q = nextLevelq;
            }
            sb.append("]");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            List<TreeNode> allNodes = new ArrayList<>();
            String[] nodes = data.substring(1,data.length()-1).split(",");
            System.out.println(Arrays.toString(nodes));
            for(int i=0; i<nodes.length; i++) {            
                TreeNode n = nodes[i].equals("null") ? null : new TreeNode(Integer.parseInt(nodes[i]));
                allNodes.add(n);
                TreeNode parent = allNodes.get((i-1)/2);
                if(i>0 && parent != null) {    
                    if(i%2==1) { // Left child
                        parent.left = n;
                    } else { // Right child
                        parent.right = n;
                    }
                }
            }
            return allNodes.get(0);
        }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));
}
