package array;

import java.util.HashMap;
import java.util.Map;


/*
Given an unsorted array A of size N of integers(positive and negative), find a continuous sub-array which adds to a given number S.
*/
class SubArraywithGivenSum {
    public static void main(String[] args) {
        int[] arr =  {15, 2, 4, 8, 9, 5, 10, 23}; 
        int sum = 23;

        findSubArraywithGivenSum(arr, sum);
    }

    private static void findSubArraywithGivenSum(int[] arr, int sum) {
        int currSum = 0;
        int start = 0;
        int end = -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            
            currSum += arr[i];
            
            // we found the sub array and it is starting form the index 0 
            if(currSum - sum == 0) {
                start = 0;
                end = i;
                break;
            }

            // we are checking if map contains value which we remove then desire sum can be obtain
            if (map.containsKey(currSum - sum)) {
                // index will be the next of what we removed 
                start = map.get(currSum - sum) + 1;
                end = i;
                break;
            }
            //System.out.println("\nkey & value: " + currSum + " " + i);
            map.put(currSum, i);
            //System.out.println("CurrSum in map");
        }

        if(end == -1) {
            System.out.println("Sub array doesn't exist!");
        }
        else {
            System.out.println("Sum found at index : " + start + " to " + end);
        }
    }
}