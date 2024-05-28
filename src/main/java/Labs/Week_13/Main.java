package Labs.Week_13;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        undirectedGraph();
        directedGraph();
        edgeWeightedGraph();
        kruskal();
    }

    public static void undirectedGraph() throws FileNotFoundException, URISyntaxException {
        /* Manually create a graph */
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        System.out.println("Number of vertices: " + g1.V());    // 5
        System.out.println("Number of edges: " + g1.E());       // 5

        /* See adjacent vertices of vertex 0 */
        /* Expected: 1, 2, 3 */
        System.out.println("Adjacent vertices of 0 (manual): ");
        Iterable<Integer> vertices1 = g1.adj(0);
        for (Integer v: vertices1) {
            System.out.println(v);
        }

        System.out.println();

        /* Read a graph from a file */
        File file = new File(Main.class.getResource("/week13/tinyG.txt").toURI());
        Graph g2 = new Graph(new Scanner(file));

        System.out.println("Number of vertices: " + g2.V());    // 13
        System.out.println("Number of edges: " + g2.E());       // 13

        /* See adjacent vertices of vertex 0 */
        /* Expected: 5, 1, 2, 6 */
        System.out.println("Adjacent vertices of 0 (file): ");
        Iterable<Integer> vertices2 = g2.adj(0);
        for (Integer v: vertices2) {
            System.out.println(v);
        }
    }

    public static void directedGraph() throws FileNotFoundException, URISyntaxException {
        /* Read a digraph from a file */
        File file = new File(Main.class.getResource("/week13/tinyDG.txt").toURI());
        Digraph g2 = new Digraph(new Scanner(file));

        System.out.println("Number of vertices: " + g2.V());    // 13
        System.out.println("Number of edges: " + g2.E());       // 22

        /* See adjacent vertices of vertex 0 */
        /* Expected: 1, 5 */
        System.out.println("Adjacent vertices of 0: ");
        Iterable<Integer> vertices1 = g2.adj(0);
        for (Integer v: vertices1) {
            System.out.println(v);
        }

        /* Reverse the graph */
        Digraph reversed = g2.reverse();

        /* See adjacent vertices of vertex 0 */
        /* Expected: 2, 6 */
        System.out.println("Adjacent vertices of 0 (reversed): ");
        Iterable<Integer> vertices2 = reversed.adj(0);
        for (Integer v: vertices2) {
            System.out.println(v);
        }
    }

    public static void edgeWeightedGraph() throws FileNotFoundException, URISyntaxException {
        /* Read a digraph from a file */
        File file = new File(Main.class.getResource("/week13/tinyEWG.txt").toURI());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(new Scanner(file));

        System.out.println("Number of vertices: " + ewg.V());    // 8
        System.out.println("Number of edges: " + ewg.E());       // 16

        /* See adjacent vertices of vertex 0 */
        /* Expected: 7, 4, 2, 6 */
        System.out.println("Adjacent vertices of 0: ");
        Iterable<Edge> edges = ewg.adj(0);
        for (Edge e: edges) {
            System.out.println(e.other(0) + ": " + e.weight());
        }
    }

    public static void kruskal() throws FileNotFoundException, URISyntaxException {
        /* Read an edge-weighted graph from a file */
        File file = new File(Main.class.getResource("/week13/tinyEWG.txt").toURI());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(
                new Scanner(file));

        /* Instantiate the Kruskal algorithm */
        KruskalMST kruskal = new KruskalMST(ewg);

        /* Print out MST edges*/
        Iterable<Edge> edges = kruskal.edges();
        for (Edge e: edges) {
            System.out.println("(" +
                    e.either() + ", " +
                    e.other(e.either()) + ") - " + e.weight());
        }

        /* Print out MST weight */
        System.out.println("MST weight: " + kruskal.weight());
    }
}