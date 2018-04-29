package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.List;

public class AllCombinationsOfNSize {
    
    static List<List<Integer>> allCombinationsSize(int n, int[] elements) {
        if(n <= 0 || elements == null || elements.length < n) return new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        allCombinationsSizeHelper(n,elements, 0, current,result);
        return result;
    }
    
    private static void allCombinationsSizeHelper(int n, int[] elements, int startIndex, ArrayList<Integer> current, List<List<Integer>> result) {
        if(n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i=startIndex; i <= elements.length-n; i++) {
            current.add(elements[i]);
            allCombinationsSizeHelper(n-1,elements,i+1,current,result);
            current.remove(current.size()-1);
        }
    }
    
    static List<List<Integer>> allCombinationsSize4(int[] elements) {
        ArrayList<List<Integer>> allCombinations = new ArrayList<List<Integer>>();
        for(int i=0; i<elements.length-3; i++) {
            for(int j=i+1; j<elements.length-2; j++) {
                for(int k=j+1; k<elements.length-1; k++) {
                    for(int l=k+1; l<elements.length; l++) {
                        ArrayList<Integer> newList = new ArrayList<>();
                        newList.add(elements[i]);
                        newList.add(elements[j]);
                        newList.add(elements[k]);
                        newList.add(elements[l]);
                        allCombinations.add(newList);
                    }
                }
            }
        }
        return allCombinations;
    }
    
    public static void main(String[] args) {
        int[] elements = {1,2,3,4,5};
        List<List<Integer>> result = allCombinationsSize4(elements);
        System.out.println(result);
        result = allCombinationsSize(4,elements);
        System.out.println(result);        
    }
}
