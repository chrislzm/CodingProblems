package com.chrisleung.other.solutions;
import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort1(int[] arr) {
		if(arr == null || arr.length < 2) return;

		for(int ki = 1; ki<arr.length; ki++) {
			int key = arr[ki];
			int i;
			for(i = ki-1; i >= 0; i--) {
				if(arr[i] > key) {
					arr[i+1] = arr[i];
				} else {
					break;
				}
			}
			arr[i+1] = key;
		}
	}

    static void insertionSort2(int arr[])
    {
        for (int keyIndex=1; keyIndex<arr.length; keyIndex++)
        {
            int key = arr[keyIndex];
            int i = keyIndex-1;
   
            // Shift items over that are greater than the key
            // This could be for-loop too but this is cleaner.
            while(arr[i] > key && i>=0)
            {
                arr[i+1] = arr[i];
                i--;
            }
            
            // Insert the key where it belongs
            arr[i+1] = key;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {1,6,3,16,2,3,6,0,20,69,29,30};
        insertionSort1(arr);
        System.out.print(Arrays.toString(arr));
    }
}
