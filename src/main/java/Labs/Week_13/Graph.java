package Labs.Week_13;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    private int V;                      // number of vertices
    private int E;                      // number of edges
    private ArrayList<Integer>[] adj;   // adjacency lists

    /* Create a Graph with V vertices and no edges */
    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];  // create an array of lists
        for (int v = 0; v < V; v++) {                   // initialize all lists
            adj[v] = new ArrayList<>();                 // the lists will hold adjacent vertices
        }
    }

    /* Create a graph from an input stream (e.g. file) */
    public Graph(Scanner in) {
        /* The first file line is V, the number of vertices*/
        this(in.nextInt());                 // construct the graph using V
        int E = in.nextInt();               // the next line is E, the number of edges

        for (int i = 0; i < E; i++) {       // iterate over all edges
            int v = in.nextInt();           // read one vertex
            int w = in.nextInt();           // read the other vertex
            addEdge(v, w);                  // add an edge between vertex v and w
        }
    }

    /* Return the number of vertices */
    public int V() {
        return V;
    }

    /* Return the number of edges */
    public int E() {
        return E;
    }

    /* Add a new edge to the graph */
    public void addEdge(int v, int w) {
        /* Since this is an undirected graph, v is connected to w
         * and w is connected to v */
        adj[v].add(w);  // connect v to w
        adj[w].add(v);  // connect w to v
        E++;            // increment the number of edges
    }

    /* Return adjacent vertices for a vertex v */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}