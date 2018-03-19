package dynamic_programming;

/*
* Given a n*m matrix where all numbers are distinct,
* find the maximum length path (starting from any cell)
* such that all cells along the path are in increasing order with a difference of 1.
*
* We can move in 4 directions from a given cell (i, j), i.e.,
* we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1)
* with the condition that the adjacent cells have a difference of 1
*
* s*/

import java.util.Scanner;

public class LongestPathInAMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        findLongestPath(matrix, n, m);

    }

    private static void findLongestPath(int[][] matrix, int n, int m) {
        int ans = 1;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) findLongestFromACell(i, j, matrix, dp, n, m);

                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }

    private static int findLongestFromACell(int i, int j, int[][] matrix, int[][] dp, int n, int m) {

        if (i < 0 || i > n - 1 || j < 0 || j > m -1) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (i > 0 && dp[i][j] == 1 + dp[i - 1][j]) dp[i][j] = findLongestFromACell(i - 1, j, matrix, dp, n, m);

        if (i < n - 1 && dp[i][j] == 1 + dp[i + 1][j]) dp[i][j] = findLongestFromACell(i + 1, j, matrix, dp, n, m);

        if (j > 0 && dp[i][j] == 1 + dp[i][j - 1]) dp[i][j] = findLongestFromACell(i, j - 1, matrix, dp, n, m);

        if (j < n - 1 && dp[i][j] == 1 + dp[i][j + 1]) dp[i][j] = findLongestFromACell(i, j + 1, matrix, dp, n, m);

        return dp[i][j] = 1;

    }
}
