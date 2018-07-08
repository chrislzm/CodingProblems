package com.chrisleung.other.solutions;

public class SecondLargestNode {

    /*
    BST
    Input: the root of a BST
    Return: the second largest node in the tree

    Every node has at most two chidlren
    Every node in left subtree < current node
    Every node in right subtree > current node

       2
    1     3
     */

    static class Node {
        Node left;
        Node right;
        int val;
        Node(Node l, Node r, int v) {
            left = l;
            right = r;
            val = v;
        }
    }

    static class Count {
        int n;
    }

    // Edge case is when we only have 1 node
    static Node secondLargest(Node root) {
        if(root == null) return null;
        return helper(new Count(), root);
    }

    static Node helper(Count count, Node node) {
        if(node == null) return null;
        Node returnVal = helper(count,node.right);
        if(count.n == 0) {
            count.n++;
            return helper(count,node.left);
        } else if(count.n == 1) {
            count.n++;
            return node;
        }
        return returnVal;    
    }

}
