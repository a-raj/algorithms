package backtrcking;

import java.util.Scanner;

public class NQueen {
    private static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Provide the size of N for N-Queen Problem: ");
        N = scanner.nextInt();
        solveNQueen();
    }

    private static void solveNQueen() {
        // 0 is default value in JAVA
        int[][] solution = new int[N][N];

        if (solveNQueenUtil(0, solution)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(solution[i][j] + "\t");
                }
                System.out.println();
            }
        }
        else System.out.println("No solution Exist");
    }

    //Recursive Function to solve N Queen problem
    private static boolean solveNQueenUtil(int column, int[][] solution) {

        if (column >= N) {
            return true;
        }
        // Try placing queens in all rows
        for (int i = 0; i < N; i++) {
            if (isSafeQueen(i, column, solution)) {
                solution[i][column] = 1;

                if (solveNQueenUtil(column + 1, solution)) {
                    return true;
                }
                //Undo : Backtrack
                solution[i][column] = 0;
            }
        }
        return false;
    }

    /* This function is called when column numbers of queens are already placed in the columns from 0 to (columns - 1)
       So we need to check only left side of the attacking queen
     */
    private static boolean isSafeQueen(int row, int column, int[][] solution) {
        //check row on left side
        for (int i = 0; i < column; i++) {
            if (solution[row][i] == 1) {
                return false;
            }
        }

        // check upper diagonal on the left side
        for (int i = row, j = column; i >= 0 && j >=0 ; i--, j--) {
            if (solution[i][j] == 1) {
                return false;
            }
        }

        //check bottom diagonal on the left side
        for (int i = row, j = column; i < N && j >= 0; i++, j--) {
            if (solution[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
