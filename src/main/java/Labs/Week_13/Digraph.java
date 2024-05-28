package Labs.Week_13;

import java.util.ArrayList;
import java.util.Scanner;

public class Digraph {
    private int V;                      // number of vertices
    private int E;                      // number of edges
    private ArrayList<Integer>[] adj;   // adjacency lists

    /* Create a Graph with V vertices and no edges */
    @SuppressWarnings("unchecked")
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];  // create an array of lists
        for (int v = 0; v < V; v++) {                   // initialize all lists
            adj[v] = new ArrayList<Integer>();          // the lists will hold adjacent vertices
        }
    }

    /* Create a graph from an input stream (e.g. file) */
    public Digraph(Scanner in) {
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
        /* Since this is a directed graph, v is only connected to w
         * and w is not connected to v */
        adj[v].add(w);  // connect v to w
        E++;            // increment the number of edges
    }

    /* Return adjacent vertices for a vertex v */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /* Create a digraph with reversed directed edges */
    public Digraph reverse() {
        Digraph R = new Digraph(V);     // initialize a new digraph
        for (int v = 0; v < V; v++) {   // iterate over all vertices
            for (int w: adj(v)) {       // iterate over all adjacent vertices of v
                R.addEdge(w, v);        // create new reversed edges (w, v)
            }
        }
        return R;                       // return the reversed digraph
    }
}