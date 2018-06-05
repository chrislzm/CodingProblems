package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModifiedSieveOfEratosthenes {

    static public List<Integer> generatePrimesThrough(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        int[] spf = new int[n]; // Smallest prime factor
        List<Integer> primes = new ArrayList<>();
        for(int curNum=2; curNum<n; curNum++) {
            if(isPrime[curNum]) {
                primes.add(curNum);
                spf[curNum] = curNum;
            }
            // This loop only touches each number once!
            for(int i=0;
                    i < primes.size() && // For each prime number
                    curNum * primes.get(i) < n && // Prime number * curNum < n
                    primes.get(i) <= spf[curNum]; // Prime number <= smallest prime factor of current number
                    i++) {                        // Above line prevents this from running multiple times per #
                int product = curNum*primes.get(i);
                isPrime[product] = false;
                spf[product] = primes.get(i);
            }
        }
        return primes;
    }
    
    public static void main(String[] args) {
        System.out.println(generatePrimesThrough(100));
    }
}
