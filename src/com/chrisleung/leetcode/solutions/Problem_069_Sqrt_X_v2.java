package com.chrisleung.leetcode.solutions;

public class Problem_069_Sqrt_X_v2 {
    
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int left = 0;
        int right = x;
        while(left <= right) {
            int mid = (left+right)/2;
            int sqrt = x/mid;
            if(sqrt < mid) {
                right = mid-1;
            } else if (sqrt > mid) {
                left = mid+1;
            } else {
                return sqrt;
            }
        }
        return right;
    }
    
}
