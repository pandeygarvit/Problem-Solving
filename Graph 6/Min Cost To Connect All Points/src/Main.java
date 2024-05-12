import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public static int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int numOfPoints = points.length;
        boolean[] visited = new boolean[numOfPoints];
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        distanceMap.put(0, 0);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, 0});

        int totalWeight = 0;

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int weight = top[0], u = top[1];

            if (visited[u] || distanceMap.getOrDefault(u, Integer.MAX_VALUE) < weight) continue;

            visited[u] = true;
            totalWeight += weight;

            for (int v = 0; v < numOfPoints; v++) {
                if (!visited[v]) {
                    int newDistance = manhattanDistance(points[u], points[v]);
                    if (newDistance < distanceMap.getOrDefault(v, Integer.MAX_VALUE)) {
                        distanceMap.put(v, newDistance);
                        minHeap.add(new int[]{newDistance, v});
                    }
                }
            }
        }

        return totalWeight;
    }
}
