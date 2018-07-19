package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_406_Queue_Reconstruction_by_Height {
    class Node {
        Node next;
        int[] person;
        Node(int[] p) {
            person = p;
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length <= 1) return people;
        Map<Integer,List<int[]>> m = new HashMap();
        for(int[] p : people) {
            List<int[]> l = m.computeIfAbsent(p[0],k->new ArrayList<int[]>());
            l.add(p);
        }
        List<Integer> heights = new ArrayList<>();
        for(Integer height : m.keySet()) {
            heights.add(height);
        }
        Collections.sort(heights,Collections.reverseOrder());
        Node head = new Node(null);
        for(int height : heights) {
            List<int[]> heightGroup = m.get(height);
            Collections.sort(heightGroup,(a,b)->a[1]-b[1]);
            for(int[] person : heightGroup) {
                Node n = head;
                int numTaller = 0;
                while(n.next != null && numTaller < person[1]) {
                    n = n.next;
                    numTaller++;
                }
                Node tmp = n.next;
                n.next = new Node(person);
                n.next.next = tmp;
            }
        }
        head = head.next;
        for(int i=0; i<people.length; i++) {
            people[i] = head.person;
            head = head.next;
        }
        return people;
    }
}
