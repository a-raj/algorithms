package array;

import java.util.Scanner;

public class SubArrayWithAGivenSum {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; ) {
                arr[i++] = sc.nextInt();
            }
            solve(arr, sum);
        }
    }
    private static void solve(int[] arr, int sum) {
        int currSum = arr[0], start = 0;
        int N = arr.length;

        // <= N to cover the last element as we have added it to the currSum, but not comparing it to the sum
        for (int i = 1; i <= N; i++) {
            if(sum - currSum < 0)
                currSum -= arr[start++];
            if (sum == currSum) {
                System.out.println(start + " " + (i - 1));
                return;
            }
            if ( i < N && sum - currSum > 0) currSum += arr[i];
        }
    }
}
