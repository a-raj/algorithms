package backtrcking;
/*
* Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
* A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in graph) from the last vertex to the first vertex of the Hamiltonian Path.
* Determine whether a given graph contains Hamiltonian Cycle or not.
* If it contains, then print the path.
* */

public class HamiltonianCycle {

    private static final int V = 5;
    public static void main(String[] args) {
        int graph[][] = {{0, 1, 0, 1, 0},
                        {1, 0, 1, 1, 1},
                        {0, 1, 0, 0, 1},
                        {1, 1, 0, 0, 1},
                        {0, 1, 1, 1, 0}};

        findHamiltonianCycle(graph);
    }

    private static void findHamiltonianCycle(int[][] graph) {

        int[] path = new int[V];
        for (int i = 0; i < V; i++) {
            path[i] = -1;
        }
        // vertex 0 as the starting vertex
        path[0] = 0;

        if (!findHamiltonianCycleUtil(graph, path, 1)){
            System.out.printf("Path doesn't exist");
            return;
        }
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + " ");
        }
    }

    private static boolean findHamiltonianCycleUtil(int[][] graph, int[] path, int pos) {

        if (pos == V) {
            // if there is an edge from the last included vertex to the first vertex then return true else false
            return (graph[path[pos - 1]][path[0]] == 1);
        }

        // Try different vertex as next candidate in hamiltonian cycle
        for (int v = 1; v < V; v++) {
            if (isSafe(graph, path, pos, v)) {
               path[pos] = v;
                if (findHamiltonianCycleUtil(graph, path, pos + 1))
                    return true;
                path[pos] = -1;
            }

        }
        return false;
    }

    private static boolean isSafe(int[][] graph, int[] path, int pos, int v) {

        // Check if this vertex is an adjacent vertex of the previously added vertex
        if (graph[ path[pos - 1] ][v] == 0)
            return false;

        // check if the vertex has already been included
        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }
        return true;
    }
}
