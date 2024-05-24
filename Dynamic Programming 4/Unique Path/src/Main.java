class Solution {

    // tabulation

    // public int uniquePaths(int m, int n) {
    //   // dp[i][j] = number of ways it takes to reach i,j from 0,0
    //   int[][] dp = new int[m][n];
    //   // base case is all [i][0] and [0][j] = 1 because the bot can reach to any of these in one step

    //   for (int i = 0; i < m; i++) {
    //     dp[i][0] = 1;
    //   }

    //   for (int j = 0; j < n; j++) {
    //     dp[0][j] = 1;
    //   }

    //   for (int i = 1; i < m; i++) {
    //     for (int j = 1; j < n; j++) {
    //       dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
    //     }
    //   }

    //   return dp[m - 1][n - 1];
    // }

    // memoization

    // public int uniquePaths(int m, int n) {
    //   int[][] mem = new int[m][n];
    //   for (int i = 0; i < m; i++) {
    //     Arrays.fill(mem[i], -1);
    //   }

    //   return solve(0, 0, m, n, mem);
    // }

    // public int solve(int row, int col, int m, int n, int[][] mem) {

    //   if (m - 1 == row || n - 1 == col) {
    //     return 1;
    //   }

    //   if (row >= m || col >= n) {
    //     return 0;
    //   }

    //   if (mem[row][col] != -1) {
    //     return mem[row][col];
    //   }

    //   int right = solve(row, col + 1, m, n, mem);
    //   int down = solve(row + 1, col, m, n, mem);

    //   return mem[row][col] = (right + down);
    // }
}