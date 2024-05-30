import java.util.*;

public class Graph {
    private int V;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertices) {
        this.V = vertices;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (int j : adjList[i]) {
                System.out.print(" " + j);
            }
            System.out.println();
        }
    }

    public void printAdjacencyMatrix() {
        int[][] adjMatrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j : adjList[i]) {
                adjMatrix[i][j] = 1;
                adjMatrix[j][i] = 1;
            }
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        // Add edges to connect each vertex to every other vertex
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        graph.printGraph();

        graph.printAdjacencyMatrix();
    }
}
