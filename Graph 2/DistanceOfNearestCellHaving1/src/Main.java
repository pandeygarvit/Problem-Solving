import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new int[] {i, j, 0}); // 0th index is for row, 1st index
                    // is for col and last index is for distance
                }
            }
        }

        while (!q.isEmpty()) {
            int[] details = q.poll();

            int row = details[0];
            int col = details[1];
            int distance = details[2];

            ans[row][col] = distance;

            int[][] factor = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

            for (int i = 0; i < 4; i++) {

                int newRow = row + factor[i][0];
                int newCol = col + factor[i][1];

                if (newRow >= 0 && newRow < grid.length
                        && newCol >= 0 && newCol < grid[0].length
                        && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                    visited[newRow][newCol] = true;
                    q.offer(new int[] {newRow, newCol, distance + 1});
                }
            }

        }

        return ans;
    }
}