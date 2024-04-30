class Solution {
    public int numSquares(int n) {
        // memoization
        // int[] dp = new int[n+1];
        // for (int i = 0; i < n+1; i++) {
        //   dp[i] = -1;
        // }
        // return solve(n, dp);

        // tabulation
        return solveTabulation(n);
    }

    public int solveTabulation(int n) {

        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int ans = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int perfectSquare = j * j;
                ans = Math.min(ans, 1 + dp[i - perfectSquare]);
            }
            dp[i] = ans;
        }

        return dp[n];
    }

    public int solveMemoization (int n, int[] dp) {
        int ans = Integer.MAX_VALUE;

        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        for (int i = 1; i * i <= n; i++) {
            int perfectSquare = i * i;
            ans = Math.min(ans, 1 + solveMemoization(n - perfectSquare, dp));
        }
        dp[n] = ans;
        return ans;
    }

    public int solveRecursive (int n) {
        int ans = Integer.MAX_VALUE;

        if (n == 0) {
            return 0;
        }

        for (int i = 1; i * i <= n; i++) {
            int perfectSquare = i * i;
            ans = Math.min(ans, 1 + solveRecursive(n - perfectSquare));
        }

        return ans;
    }
}