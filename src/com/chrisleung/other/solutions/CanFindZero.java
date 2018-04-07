package com.chrisleung.other.solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*

Refdash interview question

arr = [1, 3, 2, 0, 4, 2, 1]
startIndex = ...
startIndex = 1

If we see a cycle
 - Go a different direction
 - Try an unused element (only elements that are accessible from start index)
 
Make sure to not go out of bounds
 
return boolean
find 0
goal: see if we can visit every element
optimization -- see if zero exists off the bat

-put indicies on the queue
-remember to check the value of the indices for 0, if not 0 add the child indices to the queue


- need to mark as visited
*/
public class CanFindZero {
    // We assume positive elements in array
    boolean canFindZero(int[] arr, int startIndex) {
        if(arr == null || arr.length == 0 || startIndex < 0 || startIndex >= arr.length) {
            return false;
        }
        Set<Integer> markedIndexes = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(startIndex);
        markedIndexes.add(startIndex);
        while(!q.isEmpty()) {
            int curIndex = q.poll();
            int val = arr[curIndex];
            if(val == 0) {
                return true;
            }
            int leftChildIndex = curIndex - val;
            int rightChildIndex = curIndex + val;
            if(leftChildIndex >= 0 && !markedIndexes.contains(leftChildIndex)) {
                q.offer(leftChildIndex);
                markedIndexes.add(leftChildIndex);
            }
            if(rightChildIndex < arr.length && !markedIndexes.contains(rightChildIndex)) {
                q.offer(rightChildIndex);
                markedIndexes.add(rightChildIndex);
            }
        }
        return false;
    }    

}
