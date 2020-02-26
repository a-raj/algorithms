package array;

import java.util.Arrays;

public class CountTheTriplets {

    public static void main(String[] args) {
        int[] arr = {5, 32, 1, 7, 10, 50, 19, 21, 2};
        countTheTriplets(arr);

    }

    private static void countTheTriplets(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int count = 0;
        for (int i = n - 1; i >= 0 ; i--) {
            int left = 0;
            int right  = i - 1;

            while (left < right) {
                if (arr[left] + arr[right] == arr[i]) {
                    count++;
                    //System.out.println("");
                }

                if (arr[left] + arr[right] < arr[i]) {
                    left++;
                }
                else
                    right--;
            }
        }
        System.out.println(count);
    }
}
