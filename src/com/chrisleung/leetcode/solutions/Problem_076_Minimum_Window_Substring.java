package com.chrisleung.leetcode.solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This solution only works for "t" without duplicates.
 * Please see v2 for the full working solution.
 * @author Chris Leung
 */
public class Problem_076_Minimum_Window_Substring {
    class Solution {
        class ListNode {
            ListNode next;
            ListNode prev;
            Character c;
            ListNode(Character c) {
                this.c = c;
            }
        }
        
        public String minWindow(String s, String t) {
            Set<Character> validChars = new HashSet<>();
            for(char c : t.toCharArray()) {
                validChars.add(c);
            }
            String minString = null;
            int numChars = t.length();
            Map<Character,ListNode> windowMap = new HashMap<>();
            Map<Character,Integer> indexMap = new HashMap<>();
            char[] str = s.toCharArray();
            ListNode head = null, tail = null;
            for(int i=0; i<str.length; i++) {
                if(validChars.contains(str[i])) {
                    char c = str[i];
                    indexMap.put(c,i);
                    ListNode n = getOrCreate(c,windowMap);
                    if(n == head) {
                        head = head.next;
                    }
                    moveAfter(tail,n);
                    tail = n;
                    if(head==null) {
                        head = n;
                    }
                    if(indexMap.size() == numChars) {
                        int firstIndex = indexMap.get(head.c);
                        if(minString == null || i-firstIndex+1 < minString.length()) {
                            minString = s.substring(firstIndex,i+1);
                            System.out.println(minString);
                        }
                    }
                }
            }
            return minString == null ? "" : minString;
        }
        
        ListNode getOrCreate(Character c, Map<Character,ListNode> windowMap) {
            ListNode n = windowMap.get(c);
            if(n == null) {
                n = new ListNode(c);
                windowMap.put(c,n);
            }
            return n;
        }
        
        void moveAfter(ListNode before, ListNode after) {
            if(before != null && before != after) {
                if(before.prev == after) {
                    before.prev = after.prev;
                }
                if(after.prev != null) {
                    after.prev.next = after.next;
                }
                after.prev = before;
                after.next = before.next;
                before.next = after;
            }
        }
    }
}
