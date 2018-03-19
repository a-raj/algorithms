package dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };

        System.out.println(find_lis(arr));
    }

    private static int find_lis(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];

        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = 1;
        for (int l : lis)
            if ( max < l )
                max = l;

        return max;
    }
}
