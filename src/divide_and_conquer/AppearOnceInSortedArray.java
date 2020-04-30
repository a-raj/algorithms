package divide_and_conquer;

import java.util.Scanner;
//Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.
public class AppearOnceInSortedArray {

    public static void main(String[] args) {
        /*int[] arr = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65};*/
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int ans = findWhichAppearOnce(arr, arr.length);
            System.out.println(arr[ans]);
        }


    }

    private static int findWhichAppearOnce(int[] arr, int N) {
        int low = 0, high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 0) {
                if (arr[mid + 1] == arr[mid]) low = mid + 2;
                else high = mid - 1;
            }
            else if (mid % 2 == 1) {
                if (arr[mid - 1] == arr[mid]) low  = mid + 1;
                else high = mid;
            }
        }
        return low;
    }
}
