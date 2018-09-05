package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * O(n * n!) string permutation algorithm
 * @author Chris Leung
 *
 */
public class StringPermutations {
    
    public List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        char[] str = s.toCharArray();
        permute(str, 0, new char[str.length], result);
        return result;
    }
    
    private void permute(char[] str, int index, char[] permutation, List<String> result) {
        if(index == str.length) {
            result.add(new String(str));
            return;
        }
        for(int i=index; i<str.length; i++) {
            char c = str[i];
            permutation[index] = c;
            swap(str,index,i);
            permute(str,index+1,permutation,result);
            swap(str,index,i);
        }
    }
    
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void main(String[] args) {
        StringPermutations sp = new StringPermutations();
        System.out.println(sp.permute("abcd"));
    }
}
