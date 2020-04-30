package array;

import java.util.Scanner;

class SortArrayWith012
 {
	public static void main (String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   while(t-- > 0) {
	       int N = sc.nextInt();
	       int[] arr = new int[N];
	       for(int i = 0; i< N; i++) {
	           arr[i] = sc.nextInt();
	       }
	       solve(arr, N);
	       for (int value : arr) {
	           System.out.print(value + " ");
	       }
	   }
	}
	private static void solve(int[] arr, int N) {
	    int low = 0, mid = 0, high = N - 1;

	    while (mid <= high) {
			if (arr[mid] == 0)
				swap(arr, low++, mid++);
			else if (arr[mid] == 2)
				swap(arr, mid, high--);
			else mid++;
		}
	}
	
	private static void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}