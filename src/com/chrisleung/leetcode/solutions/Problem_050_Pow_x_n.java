package com.chrisleung.leetcode.solutions;

public class Problem_050_Pow_x_n {
    public double myPow(double x, int n) {
        double ans = 1.0;
        if(n < 0) {
            x = 1/x;
            if(n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                ans = x;
            } else {
                n = -n;
            }
        }

        double pow = x;
        for(int i=n; i>0; i /=2) {
            if(i%2 == 1) {
                ans *= pow;
            }
            pow = pow * pow;
        }
        return ans;
    }
}
