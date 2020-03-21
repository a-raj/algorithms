package array;

import java.util.Arrays;
import java.util.Scanner;

/*
* Merge two sorted array without using extra space
* */
public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 9, 10, 15, 20};
        int[] arr2 = {2, 3, 8, 13};
        merge(arr1, arr2);
    }

    private static void merge(int[] arr1, int[] arr2) {
        int x = Math.min(arr1.length, arr2.length);
        int n = arr1.length;
        for (int i = 0; i < x; i++) {
            // if array1 last element is greater than array2 first element then swap them
            if (arr1[n - 1 -i] > arr2[i]) {
                int temp = arr1[n - 1 - i];
                arr1[n - 1 - i] = arr2[i];
                arr2[i] = temp;
            }
        }

        // arrays contains all the required element sort then
        // in-order sorting is more efficient here
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
