package Labs.Week_13;

import java.util.ArrayList;
import java.util.Scanner;

public class EdgeWeightedGraph {
    private int V;                      // number of vertices
    private int E;                      // number of edges
    private ArrayList<Edge>[] adj;      // adjacency lists

    /* Create an edge-weighted graph with V vertices and no edges */
    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Edge>[]) new ArrayList[V]; // create an array of lists
        for (int v = 0; v < V; v++) {               // initialize all lists
            adj[v] = new ArrayList<>();             // the lists will hold adjacent vertices
        }
    }

    /* Create an edge-weighted graph from an input stream (e.g. file) */
    public EdgeWeightedGraph(Scanner in) {
        /* The first file line is V, the number of vertices*/
        this(in.nextInt());                     // construct the graph using V
        int E = in.nextInt();                   // the next line is E, the number of edges

        for (int i = 0; i < E; i++) {           // iterate over all edges
            int v = in.nextInt();               // read one vertex
            int w = in.nextInt();               // read the other vertex
            double weight = in.nextDouble();    // read the edge weight
            addEdge(new Edge(v, w, weight));    // add an edge between vertex v and w
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
    public void addEdge(Edge e) {
        int v = e.either();     // get the first vertex
        int w = e.other(v);     // get the other vertex
        adj[v].add(e);          // connect v to w
        adj[w].add(e);          // connect w to v
        E++;                    // increment the number of edges
    }

    /* Return adjacent vertices for a vertex v */
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    /* Return all edges in the graph */
    public Iterable<Edge> edges() {
        ArrayList<Edge> ed = new ArrayList<>();     // create a new list
        for (int v = 0; v < V; v++) {               // iterate over vertices
            for (Edge e: adj[v]) {                  // iterate over all adjacent vertices of v
                if (e.other(v) > v) {               // avoid self-loops
                    ed.add(e);                      // add the edge to the list
                }
            }
        }
        return ed;                                  // return all edges
    }
}