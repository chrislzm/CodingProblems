package com.chrisleung.other.solutions;

/*
 * Twitch technical screen Codility test question #1
 */
public class PlusMinusString {
    public String solution(int N) {
        char[] chars = {'+','-'};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(chars[i%2]);
        }
        return sb.toString();
    }
}
