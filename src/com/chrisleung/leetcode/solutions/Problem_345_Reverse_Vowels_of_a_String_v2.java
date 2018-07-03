package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Problem_345_Reverse_Vowels_of_a_String_v2 {
    static final char[] VOWELS = {'A','E','I','O','U','a','e','i','o','u'};
    
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length-1;
        while(left < right) {
            while(!isVowel(str[left]) && left < right) {
                left++;
            }
            while(!isVowel(str[right]) && left < right) {
                right--;
            }
            if(left<right) {
                char tmp = str[left];
                str[left] = str[right];
                str[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(str);
    }
    
    private boolean isVowel(char letter) {
        for(char vowel : VOWELS) {
            if(letter == vowel) {
                return true;
            }
        }
        return false;
    }
}
