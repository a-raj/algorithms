package graph;

import java.util.LinkedList;

public class Graph_AdjacencyList {

    private int v; //No of vertices
    private LinkedList<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
	Graph_AdjacencyList(int v) {
        this.v = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    public int getV() {
        return v;
    }

    LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }
}
