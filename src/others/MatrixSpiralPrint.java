package others;

import java.util.Scanner;

// Given a 2D array, print it in spiral form.
public class MatrixSpiralPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();

        int[][] matrix = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        spiralPrint(matrix, R, C);
    }

    private static void spiralPrint(int[][] matrix, int R, int C) {

        int c = 0;
        int r = 0;

        while (r < R && c < C) {

            // Print the first column
            for (int i = c; i < C; i++) {
                System.out.printf(matrix[r][i] + " ");
            }
            r++; // discard the first column

            // print the last row
            for (int i = r; i < R; i++) {
                System.out.printf(matrix[i][C - 1] + " ");
            }
            C--; // discard the last row

            if (c < C) {
                // print the last column
                for (int i = C - 1; i >= c; i--) {
                    System.out.printf(matrix[R - 1][i] + " ");
                }
                R--; // discard the last row
            }

            if (r < R) {
                // print the first row
                for (int i = R - 1; i >= r; i--) {
                    System.out.printf(matrix[i][c] + " ");
                }
                c++; //discard the first row
            }
        }
    }
}
