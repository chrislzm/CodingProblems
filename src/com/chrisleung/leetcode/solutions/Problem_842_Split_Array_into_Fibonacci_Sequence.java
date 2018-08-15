package com.chrisleung.leetcode.solutions;

import java.util.LinkedList;
import java.util.List;

public class Problem_842_Split_Array_into_Fibonacci_Sequence {
    public List<Integer> splitIntoFibonacci(String s) {
        LinkedList<Integer> result = new LinkedList<>();
        if(s == null || s.isEmpty()) return result;
        int maxLength = Math.min((s.length()/3)+1,10);
        mainLoop: // Try all possible combinations of 1st and 2nd number
        for(int i=1; i<=maxLength; i++) {
            for(int j=i+1; j<=maxLength+i; j++) {
                int first = getNum(s.substring(0,i));
                int second = getNum(s.substring(i,j));
                if(first >= 0 && second >= 0) {                 
                    result.add(first);
                    result.add(second);
                    if(findFib(j,maxLength,first,second,result, s))
                        break mainLoop;
                    result.clear();
                } 
            }
        }
        return result;
    }
    
    // Goal: Find third number that the 1st and 2nd number add up to
    boolean findFib(int startIndex, int maxLength, int first, int second, LinkedList<Integer> result, String s) {
        if(startIndex == s.length()) // Reached end of string
            return true;
        if((long)first + second > Integer.MAX_VALUE) // Out of range
            return false;
        for(int i=1; i<=maxLength; i++) { // Try all possible 3rd numbers
            if(startIndex+i <= s.length()) {
                int third = getNum(s.substring(startIndex,startIndex+i));
                if(third >= 0 && first+second == third) {
                    result.add(third);
                    if(findFib(startIndex+i,maxLength,second,third,result,s))
                        return true;
                    result.removeLast();
                }
            }
        }
        return false;
    }
    
    // Returns -1 if invalid string/number
    int getNum(String s) {
        if(s.charAt(0) == '0' && s.length() > 1) return -1;
        long result = Long.parseLong(s);
        if(result > Integer.MAX_VALUE) return -1;
        return (int)result;
    }
}
