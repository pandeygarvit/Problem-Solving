class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(distance[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.offer(new int[]{0, 0, 0}); // distance, row, col

        int[] dir = {0, 1, 0, -1, 0};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int dist = curr[0], row = curr[1], col = curr[2];

            if (row == m - 1 && col == n - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dir[i], newCol = col + dir[i + 1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newDistance = Math.max(dist, Math.abs(heights[newRow][newCol] - heights[row][col]));

                    if (distance[newRow][newCol] > newDistance) {
                        distance[newRow][newCol] = newDistance;
                        pq.add(new int[]{newDistance, newRow, newCol});
                    }
                }
            }
        }
        return 0;
    }
}
