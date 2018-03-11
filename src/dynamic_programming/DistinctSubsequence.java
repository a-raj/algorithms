package dynamic_programming;

import java.util.Arrays;

// Count distinct subsequence of a string
public class DistinctSubsequence {

    public static void main(String[] args) {
        String S = "banana";

        System.out.println(countDistinctSubsequence(S));
    }

    private static int countDistinctSubsequence(String S) {

        // Last will hold the last position of character
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int n = S.length();

        // Dp will store count of distinct subsequence of length n + 1;
        int[] dp = new int[n + 1];

        //Empty String has only one subsequence
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {

            char c = S.charAt(i - 1);

            /* No of subsequence with substring str[0...i-1] (in case of non-repeating character)
            *
            * If all character of the string are distinct, total number of subsequences is 2^n.
            * */
            dp[i] = 2 * dp[i - 1];

            /*
            * if we find any character that have already occurred before,
            * we should consider its last occurrence only (otherwise sequence won't be distinct).
            * So we have to subtract the number of subsequences due to its previous occurrence.
            * */
            if ( last[ (int) c - 'a' ] != -1 )
                dp[i] = dp[i] - dp[ last[ (int) c - 'a' ] ];

            // mark the position of the current character
            last[ (int) c - 'a' ] = i - 1;
        }
        return dp[n];
    }
}
