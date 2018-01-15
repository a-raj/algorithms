package backtrcking;


public class KnightTourProblem {

    private static final int N = 8;
    //All possible moves a Knight can take
    //NOTE : Changing order of the moves won't yield a correct solution reason unknown
    private static final int POSSIBLE_MOVES_X[] = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int POSSIBLE_MOVES_Y[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        solveKnightTourProblem();
    }

    private static boolean isMoveValid(int x, int y, int[][] solution) {
        return (x >= 0 && x < N && y >= 0 && y < N && solution[x][y] == -1);
    }

    private static void solveKnightTourProblem(){
        int[][] solution = new int[N][N];

        // Initialize the solution matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution[i][j] = -1;
            }
        }
        //initial position and state of Knight
        solution[0][0] = 0;

        //Start from x=0 & y=0 and explore all other moves
        if(knightTourProblemUtil(0, 0, 1, solution)) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf(solution[i][j] + "\t");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("No solution exists");
        }

    }

    // Recursive function to solve the problem
    private static boolean knightTourProblemUtil(int x, int y, int movesTaken, int[][] solution) {

        // All the moves completed the return
        if (movesTaken == N*N) {
            return true;
        }

        // Try all the possible moves of the Knight
        for (int i = 0; i < N; i++) {
            int nextX = x + POSSIBLE_MOVES_X[i];
            int nextY = y + POSSIBLE_MOVES_Y[i];

            if (isMoveValid(nextX, nextY, solution)) {
                solution[nextX][nextY] = movesTaken;

                // Move was valid so recursive call the function with updated X and Y position and no of Moves
                if (knightTourProblemUtil(nextX, nextY, movesTaken + 1, solution)) {
                    return true;
                }
                // Undo : backtrack
                else {
                    solution[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }
}
