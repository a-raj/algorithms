package array;

import java.util.Scanner;

class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            findLargestSumContiguousSubarray(arr);
        }

    }

    private static void findLargestSumContiguousSubarray(int[] arr) {
        int sum = Integer.MIN_VALUE, currSum = 0;
        for (int value : arr) {
            currSum += value;
            sum = Math.max(sum, currSum);
            currSum = Math.max(currSum, 0);
        }
        System.out.println(sum);
    }
}