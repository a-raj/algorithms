package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6, 7};

        merge_sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void merge_sort(int[] array, int low, int high) {

        if ( low != high) {
            int mid = (low + high) / 2;

            merge_sort(array, low , mid );
            merge_sort(array, mid+1, high );

            merge(array, low, mid, high );
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {

        int[] temp = new int[high + 1];
        int i = low;
        int j = mid +1 ;
        int k = low ;

        while( (i <= mid) && (j <= high) ) {

            if (array[i] <= array[j])
                temp[k++] = array[i++] ;

            else
                temp[k++] = array[j++] ;
        }

        while( i <= mid )
            temp[k++] = array[i++];

        while( j <= high )
            temp[k++] = array[j++];

        for (i = low; i <= high; i++)
            array[i] = temp[i];
    }
}
