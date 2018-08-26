package com.chrisleung.other.solutions;
import java.util.Arrays;

public class RadixSort {
 
    static void radixsort(int arr[])
    {
        // Get max number in order to know max # of digits
        int max = getMax(arr);
        
        // Do countSort on each digit, right to left
        // exp stores decimal "place" starting with 1s digit
        for (int exp = 1; max/exp > 0; exp *= 10)
            countSort(arr, exp);
    }

    static void countSort(int arr[], int exp)
    {
        int n = arr.length;
        int i; // index/counter var
        int table[] = new int[10]; // stores frequency/hash table
        int output[] = new int[n];
 
        // Generate digit frequency table for numbers in the array
        for (i = 0; i < n; i++) {
        	int digit = (arr[i]/exp)%10; // Extract digit from number
        	table[digit]++;
        }
        
        // Convert frequency table to hash table where key is the number's
        // digit and values are index of number in output array 
        for (i = 1; i < 10; i++)
        	table[i] += table[i - 1];
 
        // Stable sort numbers using hash table
        for (i = n - 1; i >= 0; i--)
        {
        	int digit = (arr[i]/exp)%10;
        	int sortedIndex = table[digit] - 1; 
        	output[sortedIndex] = arr[i];
        	table[digit]--;
        }
 
        // Copy sorted numbers back to original array
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static int getMax(int arr[])
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
            	max = arr[i];
        return max;
    }
     
	public static void main(String[] args) {
	       int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
	        radixsort(arr);
	        System.out.println(Arrays.toString(arr) + '\n');
	}

}
