package backtrcking;


public class KnightTourProblem {

    private static final int N = 8;
    //All possible moves a Knight can take
    //NOTE : Chnging order of the moves won't yield a correct solution reason unknown
    static final int POSSIBLE_MOVES_X[] = {2, 1, -1, -2, -2, -1, 1, 2};
    static final int POSSIBLE_MOVES_Y[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        solveKnightTourProblem();
    }

    static boolean isMoveValid(int x, int y, int[][] solution) {
        return (x >= 0 && x < N && y >= 0 && y < N && solution[x][y] == -1);
    }

    static void solveKnightTourProblem(){
        int[][] solution = new int[N][N];

        //
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution[i][j] = -1;
            }
        }
        //initial state
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

    static boolean knightTourProblemUtil(int x, int y, int movesTaken, int[][] solution) {

        if (movesTaken == N*N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            int nextX = x + POSSIBLE_MOVES_X[i];
            int nextY = y + POSSIBLE_MOVES_Y[i];

            if (isMoveValid(nextX, nextY, solution)) {
                solution[nextX][nextY] = movesTaken;

                if (knightTourProblemUtil(nextX, nextY, movesTaken + 1, solution)) {
                    return true;
                }
                else {
                    solution[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }
}
