package com.chrisleung.leetcode.solutions;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_735_Asteroid_Collision {

    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) return new int[0];
        Deque<Integer> front = new LinkedList<>();
        Deque<Integer> back = new LinkedList<>();
        for(int i=asteroids.length-1; i>=0; i--) {
            back.push(asteroids[i]);
        }
        while(!back.isEmpty()) {
            if(front.isEmpty()) {
                front.push(back.pop());
                if(back.isEmpty()) {
                    break;
                }
            }
            int f = front.peek();
            int b = back.peek();
            if(f > 0 && b < 0) { // If asteroids headed towards each other
                // Figure out the result
                if(f == -b) {
                    front.pop();
                    back.pop();
                } else if(f > -b) {
                    back.pop();
                } else {
                    front.pop();
                }
            } else {
                front.push(back.pop());
            }
        }
        int[] output = new int[front.size()];
        int i = front.size()-1;
        while(!front.isEmpty()) {
            output[i--] = front.pop();
        }
        return output;
    }

}
