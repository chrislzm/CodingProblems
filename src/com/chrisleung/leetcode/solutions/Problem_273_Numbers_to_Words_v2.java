package com.chrisleung.leetcode.solutions;

public class Problem_273_Numbers_to_Words_v2 {
    
    static final String[] LESS_THAN_20 = 
        {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    static final String[] TENS =
        {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
                "Eighty", "Ninety"};
    
    static final int[] MAGNITUDE_VALUES = {1000000000, 1000000, 1000, 1};

    static final String[] MAGNITUDE_NAMES = {"Billion", "Million", "Thousand", ""};
    

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAGNITUDE_VALUES.length; i++) {
            int numGroup = num / MAGNITUDE_VALUES[i];
            if (numGroup == 0) continue;
            sb.append(numToString(numGroup)).append(MAGNITUDE_NAMES[i]).append(' ');
            num %= MAGNITUDE_VALUES[i];
        }
        return sb.toString().trim();
    }

    /* Recursively convert numbers under 1000 to a String */
    private String numToString(int num) {
        if (num == 0) return "";
        if (num < 20) return LESS_THAN_20[num] + " ";
        if (num < 100) return TENS[num / 10] + " " + numToString(num % 10);
        // Else 100 <= num < 1000
        return LESS_THAN_20[num / 100] + " Hundred " + numToString(num % 100);
    }
}

