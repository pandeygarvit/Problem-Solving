import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<Pair>[] adjList = adjListGenerator(edges, n, succProb);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingDouble(p -> p.first));
        pq.add(new Pair(1.0, start_node));

        double[] maxProbability = new double[n];
        Arrays.fill(maxProbability, Double.MIN_VALUE);
        maxProbability[start_node] = 1.0;

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            double proba = top.first;
            int node = top.second;

            for (Pair adjacent : adjList[node]) {
                int to = adjacent.second;
                double probability = adjacent.first;
                if (maxProbability[to] < probability * proba) {
                    maxProbability[to] = probability * proba;
                    pq.add(new Pair(maxProbability[to], to));
                }
            }
        }
        return maxProbability[end_node] == Double.MIN_VALUE ? 0.0 : maxProbability[end_node];
    }

    public ArrayList<Pair>[] adjListGenerator(int[][] edges, int n, double[] succProb) {
        ArrayList<Pair>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        int i = 0;
        for (int[] edge : edges) {
            double wt = succProb[i++];
            int u = edge[0];
            int v = edge[1];

            adjList[u].add(new Pair(wt, v));
            adjList[v].add(new Pair(wt, u));
        }
        return adjList;
    }

    class Pair {
        double first;
        int second;

        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
