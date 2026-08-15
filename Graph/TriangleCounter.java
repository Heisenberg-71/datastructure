import java.util.*;

public class TriangleCounter {

    /**
     * Counts the number of triangles in an undirected graph.
     * @param edges A 2D array where each inner array represents an undirected edge [u, v]
     * @return The total number of unique triangles
     */
    public static int countTriangles(int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        // 1. Build the adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            adj.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }

        int triangleCount = 0;

        // 2. Iterate through every edge to find common neighbors
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            Set<Integer> uNeighbors = adj.get(u);
            Set<Integer> vNeighbors = adj.get(v);

            // Optimization: iterate over the smaller set to find intersections faster
            Set<Integer> smaller = (uNeighbors.size() < vNeighbors.size()) ? uNeighbors : vNeighbors;
            Set<Integer> larger = (uNeighbors.size() < vNeighbors.size()) ? vNeighbors : uNeighbors;

            for (int neighbor : smaller) {
                if (larger.contains(neighbor)) {
                    triangleCount++;
                }
            }
        }

        // 3. Each triangle is counted 3 times (once for each of its edges)
        return triangleCount / 3;
    }

    public static void main(String[] args) {
        // Reconstructing the first graph from your example data:
        // Triangles expected: (1,2,3), (3,4,7), (4,5,6) -> Total 3
        int[][] graph1 = {
                {1, 2}, {2, 3}, {3, 1},
                {3, 4}, {4, 7}, {7, 3},
                {4, 6}, {4, 5}, {5, 6}
        };

        // Reconstructing the second graph from your example data:
        // Triangles expected: (1,2,3), (3,4,6) -- assuming 6 is connected to 4 and 3 based on your input snippet
        int[][] graph2 = {
                {1, 2}, {2, 3}, {3, 1},
                {3, 4}, {4, 5}, {5, 6}, {6, 3}
        };

        System.out.println("Number of triangles in MaxLengthGraph 1: " + countTriangles(graph1)); // Output: 3
        System.out.println("Number of triangles in MaxLengthGraph 2: " + countTriangles(graph2)); // Output: 1
    }
}