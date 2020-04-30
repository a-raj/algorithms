package array;

//Given a sorted array of positive integers.
// Your task is to rearrange  the array elements alternatively
// i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on...
//Note: O(1) extra space is allowed. Also, try to modify the input array as required.
public class RearrangeArrayMaxMin {


    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 8, 9 };
        solution(arr);
    }

    private static void solution(int[] arr) {
        int maxIndex = arr.length - 1;
        int maxElement = arr[maxIndex] + 1;
        int minIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                arr[i] += arr[maxIndex--] % maxElement * maxElement;

            else
                arr[i] += arr[minIndex++] % maxElement * maxElement;
        }
        for (int value : arr) {
            System.out.print(value/maxElement + " ");
        }
    }
}
