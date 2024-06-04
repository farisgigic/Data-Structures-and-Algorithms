package Labs.Week_14;


import Labs.Week2.Queue;
import Labs.Week_13.Graph;

public class GraphSearch {

    private boolean[] marked;   // keep track of explored vertices
    private int count;          // count the explored vertices
    private Graph G;            // the graph to be searched

    /* Construct the graph search */
    public GraphSearch(Graph G) {
        marked = new boolean[G.V()];    // create an array for marking of size V
        this.G = G;                     // store the graph to be searched
    }

    /* Depth-first search (DFS) */
    public void dfs(int v) {
        marked[v] = true;               // mark the source vertex as traversed
        count++;                        // increment the number of explored vertices
        System.out.print(v + " ");      // print out the current vertex
        for (int w: G.adj(v)) {         // iterate over adjacent vertices of v
            if (!marked[w]) {           // if the vertex was not explored already,
                dfs(w);                 // recursively call DFS on it
            }
        }
    }

    /* Breadth-first search */
    public void bfs(int v) {
        Queue<Integer> queue = new Queue<>();           // create an empty queue
        marked[v] = true;                               // marked the source vertex as explored
        queue.enqueue(v);                               // add the vertex to the queue
        while (!queue.isEmpty()) {                      // as long as the queue is not empty,
            int s = queue.dequeue();                    // dequeue the vertex
            System.out.print(s + " ");                  // print out the current vertex
            for (int w: G.adj(s)) {                     // iterate over adjacent vertices of s
                if (!marked[w]) {                       // if the vertex was not explored already,
                    marked[w] = true;                   // mark it
                    queue.enqueue(w);                   // and add it to the queue
                }
            }
        }
    }

    /* Reset the search */
    public void reset() {
        marked = new boolean[G.V()];    // reset the marked array
        count = 0;                      // reset the explored vertex count
    }

    /* Check if a node w has been marked */
    public boolean marked(int w) {
        return marked[w];
    }

    /* Get the number of explored vertices */
    public int count() {
        return count;
    }
}