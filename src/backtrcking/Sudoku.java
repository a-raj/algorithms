package backtrcking;

public class Sudoku {

    private static final int N = 9;

    public static void main(String[] args) {
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        if (solveSudoku(grid)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Sudoku can't be solved");
        }
    }

    // recursive function for
    private static boolean solveSudoku(int[][] grid) {

        RowColumn rowColumn = new RowColumn(0 , 0);

        if (!findUnassignedLocation(grid, rowColumn)) {
            return true;
        }

        for (int num = 1; num <= N; num++) {
            if (isSafe(grid, rowColumn.row, rowColumn.column, num)) {
                grid[rowColumn.row][rowColumn.column] = num;

                if (solveSudoku(grid))
                    return true;

                grid[rowColumn.row][rowColumn.column] = 0;
            }
        }
        return false;

    }

    private static boolean isSafe(int[][] grid, int row, int column, int num) {

        return !usedInRow(grid, row, num) &&
                !usedInColumn(grid, column, num) &&
                !usedInBox(grid, row - row%3, column - column%3, num);
    }

    private static boolean usedInBox(int[][] grid, int boxStartingRow, int boxStartingColumn, int num) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (grid[row + boxStartingRow][column + boxStartingColumn] == num)
                    return true;
            }
        }
        return false;
    }

    private static boolean usedInColumn(int[][] grid, int column, int num) {
        for (int row = 0; row < N; row++) {
            if (grid[row][column] == num)
                return true;
        }
        return false;
    }

    private static boolean usedInRow(int[][] grid, int row, int num) {
        for (int column = 0; column < N; column++) {
            if (grid[row][column] == num)
                return true;
        }
        return false;
    }

    private static boolean findUnassignedLocation(int[][] grid, RowColumn rowColumn) {
        for (rowColumn.row = 0; rowColumn.row < N; rowColumn.row++) {
            for (rowColumn.column = 0; rowColumn.column < N; rowColumn.column++) {
                if (grid[rowColumn.row][rowColumn.column] == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    /*
    * Inner class for used so that the value of row and column as passed as a reference
    * */
    private static class RowColumn {
        int row;
        int column;

        RowColumn(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
