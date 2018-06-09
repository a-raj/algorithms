package trees.algo;

public class PrimsAlgorithm {
	
	
	private static void primMST(int[][] graph, int noOfNodes) {
		
		// represent set of vertices not yet included in MST
		boolean[] mstSet = new boolean[noOfNodes];
		
		// key value used to pick minimum weight edge in a cut
		int[] key = new int[noOfNodes];
		
		// array to store constructed MST
		int[] parent = new int[noOfNodes];
		
		// Initialize all key as Infinity
		for (int i = 0; i < noOfNodes; i++) {
			key[i] = Integer.MAX_VALUE;
		}
		
		
		// starting vertex: so mark it as 0 so it will be picked as first vertex
		key[0] = 0;
		parent[0] = -1;			// first vertex is root so -1
		
		
		// iterate through all the vertices
		for (int count = 0; count < noOfNodes - 1; count++) {
			
			// pick the minimum key vertex which is not yet included in MST
			int u = minValueIndex(mstSet, key);
			
			// Include the picked vertex in MST
			mstSet[u] = true;
			
			// Iterate through the adjacent vertices
			// Update key value & parent vertex of the picked vertex
			// Consider only those which are not included in MST
			for (int v = 0; v < noOfNodes; v++) {
				
				if ( graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		
		printMST(parent, noOfNodes, graph);
		
	}

	
	private static void printMST(int[] parent, int noOfNodes, int[][] graph) {
		System.out.println("Edge \t Weight");
		
		for (int i = 1; i < noOfNodes; i++) {
			System.out.println(parent[i] + "-" + i + " \t " + graph[i][ parent[i] ]);
		}
		
	}

	/**
     * @return index of the minimum value in key[] where sptSet is false
     * */
	private static int minValueIndex(boolean[] mstSet, int[] key) {
		
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int i = 0; i < key.length; i++) {
			if (!mstSet[i] && key[i] < minValue) {
				minValue = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}





	public static void main(String[] args) {

/* Let us create the following graph

        2    3
    (0)---(1)---(2)
     |    / \   |
    6|  8/   \5 |7
     |  /     \ |
     (3)-------(4)
          9       

*/
     
     int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                 {2, 0, 3, 8, 5},
                                 {0, 3, 0, 0, 7},
                                 {6, 8, 0, 0, 9},
                                 {0, 5, 7, 9, 0},
                                };

     // Print the solution
     primMST(graph, 5);
 
	}

}
