package Labs.Week_13;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KruskalMST {
    private ArrayList<Edge> mst;    // MST edges

    /* Perform the Kruskal's algorithm */
    public KruskalMST(EdgeWeightedGraph G) {
        mst = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        /* Add all edges to the MST */
        for (Edge e: G.edges()) {
            pq.add(e);
        }

        // Union-Find data structure - helper structure to
        // check if cycles exist in a graph
        // UnionFind will have V elements
        UnionFind uf = new UnionFind(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            // Get minimum weight edge on priority queue
            Edge e = pq.poll();     // get the edge with the lowest weight
            int v = e.either();     // extract one vertex
            int w = e.other(v);     // extract the other vertex

            if (uf.connected(v, w)) {   // if the edge forms a cycle,
                continue;               // ignore it
            }
            uf.union(v, w); // Mark two vertices as connected
            mst.add(e);     // add edge to MST
        }
    }

    /* Get a list of MST edges */
    public Iterable<Edge> edges() {
        return mst;
    }

    /* Get the weight of the MST */
    public double weight() {
        double total = 0;           // initialize
        for (Edge e: mst) {         // iterate over all MST edges
            total += e.weight();    // sum weights together
        }
        return total;               // output the weight
    }

}