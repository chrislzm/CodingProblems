package com.chrisleung.leetcode.solutions;

public class Problem_273_Numbers_to_Words {
    static final String[] SINGLE_DIGITS = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    static final String[] DOUBLE_DIGITS = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    static final String[] PLACE = {"Billion","Million","Thousand"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        for(int i=0, place = 1000000000; i < 3; place /= 1000, i++) {
            int digits = num/place;
            if(digits > 0) {
                sb.append(convertNumToString(digits));
                sb.append(" ");
                sb.append(PLACE[i]);
                num -= digits * place;
                if(num > 0) {
                    sb.append(" ");
                }
            }
        }
        if(num > 0) {
            sb.append(convertNumToString(num));
        }
        return sb.toString();
    }
    
    private String convertNumToString(int num) {
        StringBuilder sb = new StringBuilder();
        int hundreds = num / 100;
        if(hundreds > 0) {
            sb.append(SINGLE_DIGITS[hundreds]);
            sb.append(" Hundred");
            num -= hundreds*100;
            if(num > 0) {
                sb.append(" ");
            }
        }
        if(num >= 20) {
            int tens = num/10;
            sb.append(DOUBLE_DIGITS[tens]);
            num -= tens*10;
            if(num > 0) {
                sb.append(" ");
            }
        } else if(num >= 10) {
            sb.append(DOUBLE_DIGITS[num]);
            num = 0;
        }
        if(num > 0) {
            sb.append(SINGLE_DIGITS[num]);
        }
        return sb.toString();
    }
}
