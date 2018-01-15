package backtrcking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RateInAMaze {

    static final int[] POSSIBLE_MOVES_X = {1, 0, -1, 0};
    static final int[] POSSIBLE_MOVES_Y = {0, 1, 0, -1};
    static List<String> pathFollowed = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] maze = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            findSolution(maze, n);

        }
    }

    static boolean isValidMove(int x, int y, int[][] maze,int n) {
        return (x >= 0 && x < n && y >=0 && y < n && maze[x][y] == 1);
    }

    static void findSolution(int[][] maze, int n) {
        if (solveMaze(0,0, maze, n)) {
            System.out.println("The path is :");
            System.out.println("0 0");
            for (String s : pathFollowed) {
                System.out.println(s);
            }
        }
        else System.out.println("No solution Exist");
    }

    static boolean solveMaze(int x, int y, int[][] maze, int n) {

        if (x == n-1 && y == n-1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + POSSIBLE_MOVES_X[i];
            int newY = y + POSSIBLE_MOVES_Y[i];
            if (isValidMove(newX, newY, maze, n)){
                maze[newX][newY] = 2;
                pathFollowed.add(Integer.toString(newX) + " " + Integer.toString(newY));
                if (solveMaze(newX, newY, maze, n)) {
                    return true;
                }
                else maze[newX][newY] = 1;
            }
        }
        return false;
    }
}
