package dynamic_programming;


/*
* Given two strings str1 and str2 and below operations that can performed on str1.
* Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
* Insert
* Remove
* Replace
* All of the above operations are of equal cost.
* */
public class EditDistance {

    public static void main(String[] args) {
        String string1 = "ABCDF";
        String string2 = "XXACDD";

        editDistanceDP(string1, string2);
    }

    private static void editDistanceDP(String string1, String string2) {
        int m = string1.length();
        int n = string2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // If the 1st String is empty then insert all character of string2 to string1
                if (i == 0) dp[i][j] = j;

                // If the 2nd String is empty then remove all character from string1
                else if (j == 0) dp[i][j] = i;

                // If the character are same then ignore it and move to the next index
                else if (string1.charAt(i - 1) == string2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                // If last character is diff then consider all possibility of finding minimum
                else
                    dp[i][j] = 1 + Math.min( dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])); // Replace, Remove, Insert
            }
        }
        System.out.println("Minimum cost is: " + dp[m][n] + "\n");

        int i = m;
        int j = n;

        //TODO : giving wrong output for the given test case rectify it
        while (i > 0 && j > 0) {
            if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                i--;
                j--;
            }
            else {
                int min = Math.min( dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));

                if (min == dp[i - 1][j - 1]) {
                    System.out.println("Replace " + string1.charAt(i - 1) + " with " + string2.charAt(j - 1));
                    i--;
                    j--;
                }

                else if (min == dp[i - 1][j]) {
                    System.out.println("Remove " + string1.charAt(i - 1));
                    i--;
                }

                else if (min == dp[i][j - 1]) {
                    System.out.println("Insert " + string2.charAt(j - 1));
                    j--;
                }
            }

        }
    }
}
