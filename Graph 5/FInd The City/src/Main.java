import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            distance[from][to] = weight;
            distance[to][from] = weight;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        int[] reachableCities = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    reachableCities[i]++;
                }
            }
        }

        int minReachableCities = Integer.MAX_VALUE;
        int resultCity = -1;
        for (int i = 0; i < n; i++) {
            if (reachableCities[i] <= minReachableCities) {
                minReachableCities = reachableCities[i];
                resultCity = i;
            }
        }

        return resultCity;
    }
}
