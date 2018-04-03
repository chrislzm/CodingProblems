package com.chrisleung.other.solutions;

import java.util.Arrays;

/*

Refdash interview question 4/3/18

Given an array of positive integers, return the number of triangles that can be formed 
with three different array elements as three sides of triangles. 
For example, if the input array is {4, 6, 3, 7}, the output should be 3. 
There are three triangles possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. 
Note that {3, 4, 7} is not a possible triangle.

Note: For three sides to form a triangle, sum of every two sides must be greater than the third side.

// Sorted:
// {3, 4, 6, 7}
    a
       b   
          i  
          
   b = sides[j]
   a = sides[i]
   
b = 1
i=2
3 4 6
          
// length = 4
//
// j = 1 | 2 
// b = 4 | 6
// i = 0 | 0
// a = 3 | 3
// k = 2 | 3
// max = 6 | 8
// Searching k through end (6, 7)
// 

*/

public class NumTriangles {
    int numTriangles(int[] sides) {
        if(sides == null || sides.length < 3) return 0;
        Arrays.sort(sides);
        int triangles = 0;
        for(int j = 1; j < sides.length-1; j++) {
            int b = sides[j]; // 2nd item in triplet
            for(int i = 0; i < j; i++) {
                int a = sides[i]; // 1st item in triplet
                int k = j+1;
                int max = a + b - 1;
                int index = Arrays.binarySearch(sides,k,sides.length,max);
                if(index<0 && -index < sides.length) { // Either the index, or -1 - index it should be at 
                    triangles += -(index+1) - k;
                } else {
                    triangles += index - k + 1;
                }
            }
        }
        return triangles;
    }

    int binarySearch(int[] arr, int start, int end, int element) {
        if(arr == null || start < 0 || end > arr.length) return -1;
        while(start < end) {
            int mid = (start + end) / 2;
            int val = arr[mid];
            if(val == element) {
                return mid;
            } else if (element < val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
