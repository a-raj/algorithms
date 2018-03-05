package dynamic_programming;


import java.util.Scanner;

/*
* Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
* */
public class NoOfWaysToCoverADistance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        findNoOfWays(dist);
    }

    private static void findNoOfWays(int dist) {
        int[] count = new int[dist + 1];

        // One way to cover 0 and 1 distance and two ways for covering 2 distance (ie 2 steps and using 1 steps)
        count[0] = 1;
        count[1] = 1;
        count[2] = 2;
        for (int i = 3; i <= dist; i++) {
            count[i] = count[i - 1] + count[i - 2] + count[i - 3];
        }
        System.out.println(count[dist]);
    }
}
