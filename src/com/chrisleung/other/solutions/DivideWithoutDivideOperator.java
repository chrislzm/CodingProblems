package com.chrisleung.other.solutions;

// Amazon technical phone screen question #2
public class DivideWithoutDivideOperator {
 // Return a / b
 // Can't use /

 // 16 
 // 2
 // 2, 4, 8 , 16
 // 2 ^ 4
 // 2 + 2 + 2 + 2 = 8

 // 24 / 3
 // 3, 9, 27
 // 3^2
 // 24 - 9
 // 13 - 9
 // 3^2
 // 4
 // 3
 // 3^2 + 3^2 + 3

 //              b              a 
 // ------0-1-2-3----8---------24-----

 // Check for negatives/positive inputs 

 // Implement a/b (a divided by b)
 // log(a) runtime complexity, O(1) space complexity
 // a/b
 // Throw checked/unchecked exception depending on requirements of system
 int divide(int a, int b) throws InvalidArgumentException {
     if(a == 0) return 0;
     if(b == 0) throw new InvalidArgumentException();
     boolean positiveResult = (a > 0 && b > 0) || (a < 0 && b < 0) ? true : false;
     a = Math.abs(a);
     b = Math.abs(b);
     int left = 0;
     int right = a;
     while(left <= right) {
         int mid = left+right >>> 1;  // Integer.MAX_VALUE * 2  11111111    01001010101
         int product = mid * b;
         if(product < a) {
             left = mid+1;
         } else if(product > a) {
             right = mid-1;
         } else {
             return positiveResult ? mid : -mid;
         }
     }
     return positiveResult ? right : -right; // Truncate and return smaller numbermber
 }
}
