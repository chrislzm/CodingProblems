package com.chrisleung.other.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Houzz Tech Phone Screen Interview Question 5/1/18
 * @author Chris Leung
 *
 */
public class PrimeFactorization {

    public static void main(String[] args) {
      printPrimeFactors(89);
    }

    // Sieve of eratosthenes
    static LinkedHashSet<Integer> getPrimes(int n) {
      boolean[] primes = new boolean[n+1];
      Arrays.fill(primes,true);
      primes[0] = false;
      primes[1] = false;
      int prime = 2;
      while(prime < Math.sqrt(n)) {
        checkOff(primes,prime);
        prime = getNextPrime(primes, prime);
      }
      LinkedHashSet<Integer> output = new LinkedHashSet<>();
      for(int i=2; i<primes.length; i++) {
        if(primes[i]) {
          output.add(i);
        }
      }
      return output;
    }
    // n - 1, n - 2 ...  1 -  O(n^2) 
    private static void checkOff(boolean[] primes, int n) {
      int i = n*n;
      int count = 2;
      while(i < primes.length) {
        primes[i] = false;
        i += n;
      }
    }

    private static int getNextPrime(boolean[] primes, int n) {
      n+=1;
      while(n < primes.length && primes[n] == false) {
        n++;
      }
      return n;
    }
    
    static void printPrimeFactors(int originalNum) {
      // TODO: Input validation
      // Check negative, check 0, 1
      int n = originalNum;
      LinkedHashSet<Integer> primes;
      // Generate prime numbers through n
      primes = getPrimes(n);
      List<Integer> primefactors = new ArrayList<>();
      // If it's a prime number
      if(primes.contains(n)) {
        primefactors.add(n);
      } else {
        // Find the prime factorization
        while(n != 1) {
          for(int prime : primes) {
            if(n%prime == 0) {
              primefactors.add(prime);
              n /= prime;
              break;
            }
          }
        }
      }
      // TODO : Print prime factors
      System.out.printf("%s = ",originalNum);
      for(int i=0; i<primefactors.size()-1; i++) {
        System.out.printf("%s * ", primefactors.get(i));
      }
      System.out.print(primefactors.get(primefactors.size()-1)); // Print last one
    }

}
