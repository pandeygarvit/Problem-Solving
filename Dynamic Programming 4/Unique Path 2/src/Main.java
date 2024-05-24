class Solution {

    // tabulation

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return 0
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        // Initialize the first column
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        // Initialize the first row
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
    // memoization

    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //   int m = obstacleGrid.length;
    //   int n = obstacleGrid[0].length;

    //   if (obstacleGrid[m - 1][n - 1] == 1) {
    //     return 0;
    //   }

    //   int[][] mem = new int[m][n];
    //   for (int i = 0; i < m; i++) {
    //     Arrays.fill(mem[i], -1);
    //   }

    //   return solve(0, 0, m, n, obstacleGrid, mem);
    // }

    // public int solve(int row, int col, int m, int n, int[][] obstacleGrid, int[][] mem) {

    //   if (row == m - 1 && col == n - 1) {
    //     return 1;
    //   }

    //   if (row >= m || col >= n) {
    //     return 0;
    //   }

    //   if (obstacleGrid[row][col] == 1) {
    //     return mem[row][col] = 0;
    //   }

    //   if (mem[row][col] != -1) {
    //     return mem[row][col];
    //   }

    //   int right = solve(row, col + 1, m, n, obstacleGrid, mem);
    //   int down = solve(row + 1, col, m, n, obstacleGrid, mem);

    //   return mem[row][col] = (right + down);
    // }
}