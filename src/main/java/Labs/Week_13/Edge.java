package Labs.Week_13;

public class Edge implements Comparable<Edge> {

    private int v;              // one vertex
    private int w;              // the other vertex
    private double weight;      // edge weight

    /* Create an Edge object */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /* Retrieve the weight of the edge */
    public double weight() {
        return weight;
    }

    /* Return one of the vertices; in this case, v */
    public int either() {
        return v;
    }

    /* Return the other vertex */
    public int other(int vertex) {
        if (vertex == v) {          // if provided the first vertex,
            return w;               // return the second one
        } else if (vertex == w) {   // if provided the other vertex,
            return v;               // return the first one
        } else {                    // throw an error for a wrong vertex
            throw new RuntimeException("Inconsistent edge");
        }
    }

    /* Compare two Edges */
    public int compareTo(Edge e) {
        double diff = this.weight - e.weight();
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}