package com.chrisleung.leetcode.solutions;

public class Problem_788_Rotated_Digits {
    
    public int rotatedDigits(int n) {
        int num;
        boolean flag;
        int ans = 0;
        for(int i=1; i<=n; i++) {
            // Check each digit
            num = i;
            flag=false;
            while(num > 0) {
                int digit = num%10;
                if(digit == 3 || digit == 4 || digit == 7) {
                    flag=true;
                    break;
                }
                num /= 10;
            }
            if(flag)
                continue;
            num = i;
            while(num > 0) {
                int digit = num %10;
                if(digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                    flag = true;
                    break;
                }
                num /= 10;
            }
            if(flag)
                ans++;
        }
        return ans;
    }
}
