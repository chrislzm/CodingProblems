package com.chrisleung.other.solutions;

/**
 * interviewing.io problem
 * @author Chris Leung
 */

class Node {
    Node prev; // left
    Node next; // right
    Integer data;
    Node(Integer d) {
        data = d;
    }
}

public class BinaryTreeToLinkedList {

    public static void main(String[] args) {
        BinaryTreeToLinkedList s = new BinaryTreeToLinkedList();

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n5.prev = n3;
        n5.next = n7;
        n3.prev = n2;
        n3.next = n4; 
        n7.prev = n6;
        n7.next = n8;

        Node list = s.treeToList(n5);
        s.printListForward(list);
        s.printListReverse(list);
    }

    // Problem 1(a)
    // Given the head of a circular doubly linked list, print the contents of that list starting with the head in forward order
    public void printListForward(Node head) {
        System.out.println("----");
        if(head==null) return;
        Node cur = head;
        do {
            System.out.println(cur.data);
            cur = cur.next;
        } while(cur != head);
    }

    // Problem 1(b)
    // Given the head of a circular doubly linked list, print the contents of that list in reverse order, starting with the tail
    public void printListReverse(Node head) {
        System.out.println("----");
        if(head==null) return;
        Node tail = head.prev;
        Node cur = tail;
        do {
            System.out.println(cur.data);
            cur = cur.prev;
        } while(cur != tail);
    }  

    // Problem 1(c)
    // Given the heads of two circular doubly linked lists, append the second list to the first and return the 
    // head of the resulting list
    // first: 1<->3<->4[<->1]
    // second: 5<->6<->7[<->5]
    // result: 1<->3<->4<->5<->6<->7[<->1]
    public Node appendLists(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        // Get tail of first list
        Node tail1 = head1.prev;
        // Get tail of second list
        Node tail2 = head2.prev;
        // Make head of first list and tail of the second list point to each other
        head1.prev = tail2;
        tail2.next = head1;    
        // Make the tail of the first list and head of the 2nd list point to each other
        tail1.next = head2;
        head2.prev = tail1;
        return head1;
    }

    // Problem 1(d): 
    // Given a binary tree, convert it to a circular doubly linked list (in place) and return the head of that list. 
    // For an example-
    // Input:
    //         5
    //      /      \
    //   3        7
    //  / \      / \
    // 2   4    6   8
    // Result: 2<->3<->4<->5<->6<->7<->8[<->2]
    //       2
    //    1     3
    //     n2.prev.next = n2;
    //     n2.next.prev = n2;
    //     n1.prev = n3;
    //     n3.next = n1;

    //          4
    //       2
    //    1     3
    //     n2.prev.next = n2;
    //     n2.next.prev = n2;
    //     n1.prev = n3;
    //     n3.next = n1;

    // Traverse left, pass the parent down
    public Node treeToList(Node root) {
        if(root == null) {
            return null;
        }
        // ???
        Node left = treeToList(root.prev);
        Node right = treeToList(root.next);
        root.next = root;
        root.prev = root;
        left = appendLists(left,root);
        left = appendLists(left,right);
        return left;
    }

    // Traverse left, pass the parent down
    public void printInOrder(Node root) {
        if(root == null) return;
        printInOrder(root.prev);
        System.out.println(root.data);
        printInOrder(root.next);
    }



}
