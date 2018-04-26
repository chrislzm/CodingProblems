package com.chrisleung.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem_247_Strobogrammatic_Number_II {
    // Numbers that look the same upside down
    // 1, 8, 0
    // Pairs that look the same upside down
    // 69, 96
    // Can only appear alone or between other numbers
    // 0
    // Idea: Use a string and append to the front and back of it at each level
    public List<String> findStrobogrammatic(int n) {
        List<String> output = new ArrayList<>();
        strobogrammaticHelper("",n,output);
        return output;
    }
    
    private void strobogrammaticHelper(String s,int n,List<String> output) {
        if(n == 0) {
            output.add(s);
            return;
        }
        if(n % 2 == 1) {
            strobogrammaticHelper("0",n-1,output);
            strobogrammaticHelper("1",n-1,output);
            strobogrammaticHelper("8",n-1,output);
        } else {
            strobogrammaticHelper("1" + s + "1",n-2,output);
            strobogrammaticHelper("6" + s + "9",n-2,output);
            strobogrammaticHelper("8" + s + "8",n-2,output);
            strobogrammaticHelper("9" + s + "6",n-2,output);
            if(n >= 4) {
                strobogrammaticHelper("0" + s + "0",n-2,output);
            }
        }
    }
}
