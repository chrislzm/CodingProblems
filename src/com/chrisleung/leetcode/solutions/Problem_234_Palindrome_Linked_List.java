package com.chrisleung.leetcode.solutions;

public class Problem_234_Palindrome_Linked_List {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) { // Odd number of nodes
            slow = slow.next;
        }
        // Reverse 2nd half of the list
        ListNode prev = null;
        ListNode cur = slow;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // Prev now holds the head of the reversed 2nd half
        while(prev != null) {
            if(head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
}
