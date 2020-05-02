package array;

import java.util.Arrays;
import java.util.Scanner;

public class EquilibriumPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int equilibriumPoint = findEquilibriumPoint(arr);
            System.out.println(equilibriumPoint);
        }
    }

    private static int findEquilibriumPoint(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            if (sum == leftSum)
                return i;
            leftSum += arr[i];
        }
        return -1;
    }

    

}
