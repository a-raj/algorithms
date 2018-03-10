package dynamic_programming;


import java.util.Scanner;

/*
* Given a two strings S and T, find count of distinct occurrences of T in S as a subsequence.
* */
public class CountDistinctOccurrenceAsASubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();
        String T = scanner.next();

        System.out.println( findSubsequenceCout(S, T) ) ;

    }

    private static int findSubsequenceCout(String S, String T) {
        int m = T.length();
        int n = S.length();

        if (m > n) return 0;

        int[][] dp = new int[m + 1][n + 1];

        /* Initialize first column as 0
        *  An empty string can't be substring of another string.
        * */
        for (int i = 1; i <= m; i++)
            dp[i][0] = 0;

        /*
        * Initialize first row as 1,
        * An empty string is sub-sequence of all
        * */
        for (int i = 0; i <= n; i++)
            dp[0][i] = 1;

        // fill dp in bottom up manner;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                /*
                * If last character is not equals,
                * then value is same as value without the last character in S
                * */
                if (T.charAt(i - 1) != S.charAt(j - 1))
                    dp[i][j] = dp[i][j - 1];

                /*
                * Else value is obtained considering two cases
                * a. all substrings without the last character in S
                * b. all substrings without the last character in both
                * */
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
            }
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[m][n];
    }

}
