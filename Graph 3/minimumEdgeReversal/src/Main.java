import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Solution {
    public static int minimumEdgeReversal(int[][] edges, int numNodes, int numEdges, int src, int dst) {
        // code here

        // 1 -> 2 -> 3 -> 4

        // 6 <- 4 <- 5
        //      ^
        //      |
        // 1 -> 2 <- 3


        // 1 -> 2 <- 3

        // source = src
        // dist[vertex] = {}
        // dist[dst]

        // source(index) -> *{destination, weight}
        // 0 ->
        // 1 -> {2, 0}
        // 2 -> {{1, 1}, {3, 1}}
        // 3 -> {2, 0}

        ArrayList<Pair>[] adjacencyList = adjacencyListGenerator(edges, numNodes+1, numEdges);

        int[] distance = new int[numNodes+1];
        for (int i = 0; i < numNodes+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(src);


        while(!q.isEmpty()) {
            int node = q.removeFirst();

            for (Pair adjNode: adjacencyList[node]) {
                int adj = adjNode.destination;
                int wt = adjNode.weight;

                if (distance[adj] > distance[node] + wt) {
                    distance[adj] = distance[node] + wt;

                    if (wt == 0) {
                        q.addFirst(adj);
                    } else {
                        q.addLast(adj);
                    }
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    public static ArrayList<Pair>[] adjacencyListGenerator(int[][] edges, int numNodes, int numEdges) {

        ArrayList<Pair>[] adjacencyList = new ArrayList[numNodes];

        for (int i = 0; i < numNodes; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int edge[]: edges) {
            int nodeOne = edge[0];
            int nodeTwo = edge[1];

            //nodeOne -> nodeTwo will have weight 0
            //nodeTwo -> nodeOne will have weight 1

            adjacencyList[nodeOne].add(new Pair(nodeTwo, 0));
            adjacencyList[nodeTwo].add(new Pair(nodeOne, 1));
        }

        return adjacencyList;
    }

}

class Pair {
    int destination;
    int weight;

    Pair(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}