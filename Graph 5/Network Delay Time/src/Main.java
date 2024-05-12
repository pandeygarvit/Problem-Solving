import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<Pair>[] adjList = adjListGenerator(times, n);

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.first));
        pq.add(new Pair(0, k));
        minTime[k - 1] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int wt = curr.first;
            int node = curr.second;

            for (Pair pair : adjList[node - 1]) {
                int adjWt = pair.first;
                int adj = pair.second;

                if (minTime[adj - 1] > wt + adjWt) {
                    minTime[adj - 1] = wt + adjWt;
                    pq.add(new Pair(minTime[adj - 1], adj));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, minTime[i]);
        }

        return ans;
    }

    public ArrayList<Pair>[] adjListGenerator(int[][] times, int n) {
        ArrayList<Pair>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adjList[u - 1].add(new Pair(wt, v));
        }
        return adjList;
    }

    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
