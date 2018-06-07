package shortest_path;

public class DijkstrasImplementation {

    public static void main(String[] args) {
        int graph[][] = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                    {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                    {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                    {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                    {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                    {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                    {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                    {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                    {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph, 0, 9);
    }

    private static void dijkstra(int[][] graph, int src, int V) {

        int[] distance = new int[V];

        // Shortest Path Tree Set
        boolean[] sptSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        // Distance of source vertex to itself
        distance[src] = 0;


        // find Shortest path for all the vertex
        for (int i = 0; i < V - 1; i++) {

            // Find the minimum distance vertex from the set of vertices not yet processed.
            int u =  minimumDistance(distance, sptSet, V);

            // mark the picked vertex as processed
            sptSet[u] = true;

            // Update the distance value of the adjacent vertices of the picked vertices
            for (int v = 0; v < V; v++) {

                /* Update distance[v]
                    if it is not in sptSet,
                    there is an edge from u to v
                    and total weight of the path from src to v through u is smaller than the current value of distance[v]
                */
                if (!sptSet[v] && graph[u][v] != 0  && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

    }

    private static int minimumDistance(int[] distance, boolean[] sptSet, int V) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < V; v++) {
            if ( !sptSet[v] && distance[v] <= min) {
                min = distance[v];
                min_index = v;
            }
        }
        return min_index;


    }
}
