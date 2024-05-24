class Solution {

    // tabulation

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    // public int minPathSum(int[][] grid) {
    //   int m = grid.length;
    //   int n = grid[0].length;

    //   int[][] mem = new int[m][n];

    //   for (int i = 0; i < m; i++) {
    //     Arrays.fill(mem[i], -1);
    //   }

    //   return solve(grid, 0, 0, m, n, mem);
    // }

    // public int solve(int[][] grid, int row, int col, int m, int n, int[][] mem) {

    //   if (row >= m || col >= n) {
    //     return Integer.MAX_VALUE;
    //   }

    //   if (row == m - 1 && col == n - 1) {
    //     return grid[row][col];
    //   }


    //   if (mem[row][col] != -1) {
    //     return mem[row][col];
    //   }

    //   int right = solve(grid, row, col + 1, m, n, mem);
    //   int down = solve(grid, row + 1, col, m, n, mem);

    //   return mem[row][col] = grid[row][col] + Math.min(right, down);
    // }

    // public int minPathSum(int[][] grid) {
    //   int m = grid.length;
    //   int n = grid[0].length;

    //   for (int i = 1; i < m; i++) {
    //     grid[i][0] += grid[i-1][0];
    //   }

    //   for (int j = 1; j < n; j++) {
    //     grid[0][j] += grid[0][j-1];
    //   }

    //   for (int i = 1; i < m; i++) {
    //     for (int j = 1; j < n; j++) {
    //       grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
    //     }
    //   }

    //   return grid[m-1][n-1];
    // }
}