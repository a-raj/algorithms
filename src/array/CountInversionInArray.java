package array;

import java.util.Arrays;

// Count Inversions in an array
//Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
//Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
public class CountInversionInArray {

    public static void main(String[] args) {
        int[] arr = { 1, 20, 6, 4, 5 };
        //int[] arr = {4, 5, 6, 7, 1};
        int ans = merge_sort(arr, 0, arr.length - 1);
        System.out.println(ans);
    }

    private static int merge_sort(int[] array, int low, int high) {
        int count = 0;
        if ( low< high) {
            int mid = (low + high) / 2;
            count += merge_sort(array, low , mid );
            count +=  merge_sort(array, mid+1, high );
            count += merge(array, low, mid, high );
        }
        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int N1 = mid - low + 1;
        int N2 = high - mid;
        int[] left = new int[N1];
        int[] right = new int[N2];

        for (int i = 0; i < N1; i++) left[i] = arr[low + i];
        for (int i = 0; i < N2; i++) right[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = low, count = 0;

        while (i < N1 && j < N2) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                count += (N1 - i);
            }
        }
        while (i < N1) arr[k++] = left[i++];
        while (j < N2) arr[k++] = right[j++];
        return count;
    }


}
