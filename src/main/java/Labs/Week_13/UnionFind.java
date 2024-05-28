package Labs.Week_13;

public class UnionFind {
    private final int[] sets;

    public UnionFind(int n) {
        sets = new int[n];              // initialize the array
        for (int i = 0; i < n; i++) {   // for each member of the set
            sets[i] = i;                // initialize the set
        }
    }

    /* Return the representative element of element u */
    public int find(int u) {
        return sets[u];
    }

    /* Add element u into element w's set */
    public void union(int u, int w) {
        int rootU = find(u);                        // find the set representative of u
        int rootW = find(w);                        // find the set representative of w

        for (int i = 0; i < sets.length; i++) {     // iterate through the sets
            if (sets[i] == rootU) {                 // if the element was previously in u's set
                sets[i] = rootW;                    // now add it to w's set
            }
        }
    }

    /* Check if elements u and w are connected */
    public boolean connected(int u, int w) {
        // elements are connected if their representatives are equal
        return find(u) == find(w);
    }
}