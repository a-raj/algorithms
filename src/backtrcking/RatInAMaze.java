package backtrcking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1].
* A rat starts from source and has to reach destination.
* The rat can move only in two directions: forward and down.
* */
public class RatInAMaze {

    static final int[] POSSIBLE_MOVES_X = {1, 0, -1, 0};
    static final int[] POSSIBLE_MOVES_Y = {0, 1, 0, -1};
    static List<String> pathFollowed = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            System.out.print("Provide the size of the maze : ");
            int n = scanner.nextInt();
            int[][] maze = new int[n][n];
            System.out.println("Provide the maze 0 mean wall and 1 mean path");
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
