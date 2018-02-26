package dynamic_programming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        findLCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
    }

    private static void findLCS(char[] X, char[] Y, int m, int n) {

        int[][] lcs = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {

            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0) lcs[i][j] = 0;

                else if (X[i-1] == Y[j-1]) lcs[i][j] = lcs[i - 1][j - 1] + 1;

                else lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
        int length = lcs[m][n];

        StringBuilder ans = new StringBuilder(length);

        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (X[i] == Y[j]) {
                ans.append( X[i] );
                i--;
                j--;
            }
            else if (lcs[i - 1][j] > lcs[i][j - 1]) i--;
            else j--;
        }

        System.out.println(ans.reverse().toString());
    }
}
