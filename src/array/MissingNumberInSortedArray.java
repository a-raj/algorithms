package array;

public class MissingNumberInSortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};
        System.out.println(findMissingNumber(arr));
    }

    private static int findMissingNumber(int[] arr) {
        int N = arr.length;
        int left = 0, right = N - 1;

        while(left <= right) {
            int mid = (left + right)  / 2;

            //if the middle element is not on the middle index, then the missing element is mid + 1
            if (arr[mid] != mid + 1 && arr[mid - 1] == mid) return mid + 1;

            //missing element not in the left
            if (arr[mid] == mid + 1) left = mid + 1;

            // if it is not in the left then it will be on the right
            else right = mid - 1;
        }
        return -1;
    }
}
