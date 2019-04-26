package array;

class LargestSumContiguousSubarray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        findLargestSumContiguousSubarray(arr, arr.length);

    }

    private static void findLargestSumContiguousSubarray(int[] arr, int length) {
        
        int maxSoFar = arr[0];
        int currMax = arr[0];
        
        for (int i = 1; i < length; i++) {
            // Check whether the current max is greater or the after adding the present value to the current max
            currMax = Math.max(currMax, currMax + arr[i]);

            // Update max so far
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        System.out.println(maxSoFar);
    }
}