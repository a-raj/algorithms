package array;

import java.util.HashMap;
import java.util.Map;

// Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
public class CountTheTriplets {

    public static void main(String[] args) {
        int[] arr = {7,2,5,4,3,6,1,9,10,12};
        countTheTriplets(arr);

    }

    private static void countTheTriplets(int[] arr) {

        int N = arr.length;
        int count = 0;
        // value and its index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++)
            map.put(arr[i], i);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(sum))
                    count++;
            }
        }
        System.out.println(count);
    }
}
