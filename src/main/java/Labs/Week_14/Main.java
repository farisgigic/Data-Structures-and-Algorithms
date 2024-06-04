package Labs.Week_14;

import Labs.Week_13.Edge;
import Labs.Week_13.EdgeWeightedGraph;
import Labs.Week_13.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        graphSearch();
        prim();
    }

    public static void graphSearch() {
        /* Create a graph */
        Graph g = new Graph(6);
        g.addEdge(0, 5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(5, 3);
        g.addEdge(3, 2);
        g.addEdge(4, 2);

        GraphSearch gs = new GraphSearch(g);

        /* Traverse over the graph using DFS */
        System.out.print("DFS: ");
        gs.dfs(0);

        /* Reset the search */
        System.out.println();
        gs.reset();

        /* Traverse over the graph using BFS*/
        System.out.print("BFS: ");
        gs.bfs(0);
    }

    public static void prim() throws URISyntaxException, FileNotFoundException {
        /* Read an edge-weighted graph from a file */
        File file = new File(Main.class.getResource("/week13/tinyEWG.txt").toURI());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(
                new Scanner(file));

        /* Instantiate the lazy Prim's algorithm */
        PrimMST prim = new PrimMST(ewg);

        /* Print out MST edges*/
        Iterable<Edge> edges = prim.edges();
        for (Edge e: edges) {
            System.out.println("(" +
                    e.either() + ", " +
                    e.other(e.either()) + ") - " + e.weight());
        }

        /* Print out MST weight */
        System.out.println("MST weight: " + prim.weight());
    }
}