package trees.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        Graph_AdjacencyList graph = new Graph_AdjacencyList(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        bfs(2, graph, 4);
        System.out.println("\n");
        bfsWithLevels(2, graph, 4);
    }

    static void bfs(int s, Graph_AdjacencyList graph, final int v) {

        boolean[] visited = new boolean[v];

        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while ( !queue.isEmpty() ) {
            s = queue.poll();
            System.out.printf(s + " ");

            for (Integer n : graph.getAdjacencyList()[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }

            }
        }
    }

    static void bfsWithLevels(int s, Graph_AdjacencyList graph, final int v) {

        boolean[] visited = new boolean[v];

        Queue<Integer> queue = new LinkedList<>();
        int[] levels = new int[v];

        visited[s] = true;
        queue.add(s);
        levels[s] = 0;

        while ( !queue.isEmpty() ) {
            s = queue.poll();
            System.out.println("vertex " + s + "\t levels : " + levels[s]);

            for (Integer n : graph.getAdjacencyList()[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    levels[n] = levels[s] + 1;
                }

            }
        }
    }
}
