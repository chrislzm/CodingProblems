/**
 * Submitted as part of Leetcode Weekly Contest 68.
 * Because of competition time constraints, code will definitely not be the cleanest. ;-)
 */

package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_767_Reorganize_String {

    class CharFreq {
        char c;
        int num;
        CharFreq(char d, int m) {
            c = d;
            num = m;
        }
    }
    
    public String reorganizeString(String S) {
        // Total the num of characters
        Map<Character,CharFreq> m = new HashMap<>();
        for(char c: S.toCharArray()) {
            CharFreq p = m.get(c);
            if(p == null) { 
                p = new CharFreq(c,0);
                m.put(c, p);
            }
            p.num++;
        }
        
        // Add to list and sort in decreasing frequency 
        List<CharFreq> vals = new ArrayList<>(m.values());
        Collections.sort(vals,(a,b)->b.num-a.num);
        
        // Test: If freq of the largest # characters minus 1 is greater than all the other characters combined, then not possible
        if(vals.size() <= 1) return "";
        CharFreq tmp = vals.remove(0);
        int first = tmp.num;
        int rest = 0;
        for(CharFreq v : vals) {
            rest += v.num;
        }
        if(first-1 > rest) return "";
        
        // Passed test: It's possible. Add back to list.
        vals.add(tmp);

        // Create a max-heap to get the largest #, then get the 2nd largest, and repeat to build the string
        PriorityQueue<CharFreq> q = new PriorityQueue<>(10,(a,b)->b.num-a.num);
        for(CharFreq val : vals) {
            q.add(val);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            CharFreq p1 = q.remove();
            if(q.isEmpty()) {
                sb.append(p1.c);
            } else {
                CharFreq p2 = q.remove();                
                sb.append(p1.c);
                p1.num--;
                sb.append(p2.c);
                p2.num--;
                if(p1.num > 0) q.add(p1);
                if(p2.num > 0) q.add(p2);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Problem_767_Reorganize_String p = new Problem_767_Reorganize_String();
        System.out.println(p.reorganizeString("aaaaabbbc"));
    }

}
