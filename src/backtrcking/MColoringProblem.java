package backtrcking;

/*
* Given an undirected graph and a number m,
* determine if the graph can be colored with at most m colors
* such that no two adjacent vertices of the graph are colored with same color.
* Here coloring of a graph means assignment of colors to all vertices.
* */
public class MColoringProblem {
    private static final int V = 4;

    public static void main(String[] args) {
        // adjacency matrix representing graph
        int graph[][] = {{0, 1, 1, 1},
                        {1, 0, 1, 0},
                        {1, 1, 0, 1},
                        {1, 0, 1, 0}};
        int m = 3; // Number of colors
        solveGraphColoring(graph, m);
    }

    private static void solveGraphColoring(int[][] graph, int m) {
        int[] colors = new int[V];
        if (!solveGraphColoringUtil(graph, m, colors, 0)) {
            System.out.printf("Solution doesn't exist");
            return;
        }
        for (int color : colors) {
            System.out.printf(color + " ");
        }
    }

    private static boolean solveGraphColoringUtil(int[][] graph, int m, int[] colors, int v) {
        // base case : all vertices are colored
        if (v == V) {
            return true;
        }
        // try every possible color for vertex v
        for (int i = 1; i <= m; i++) {
            if (isSafe(graph, v, colors, i)) {

                colors[v] = i;
                // find solution for next vertex
                if (solveGraphColoringUtil(graph, m, colors, v + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] graph, int v, int[] colors, int c) {
        // find if the adjacent vertex have same color
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && colors[i] == c)
                return false;
        }
        return true;
    }
}
