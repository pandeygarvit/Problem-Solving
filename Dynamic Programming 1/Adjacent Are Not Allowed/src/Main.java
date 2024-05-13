import java.util.Arrays;

class Solution {
    static int Memoization(int[][] nums, int idx, int[] dp) {
        if (idx >= nums[0].length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int not_take = Memoization(nums, idx + 1, dp);
        int take = Memoization(nums, idx + 2, dp) + Math.max(nums[0][idx], nums[1][idx]);

        return dp[idx] = Math.max(take, not_take);
    }

    static int Tabulation(int[][] nums) {
        int n = nums[0].length;
        int[] dp = new int[n + 2];

        for (int idx = n - 1; idx >= 0; idx--) {
            int not_take = dp[idx + 1];
            int take = dp[idx + 2] + Math.max(nums[0][idx], nums[1][idx]);

            dp[idx] = Math.max(take, not_take);
        }

        return dp[0];
    }

    static int SpaceOptimization(int N, int[][] mat) {
        int temp1 = Math.max(mat[0][0], mat[1][0]);
        if (N == 1)
            return temp1;

        int temp2 = Math.max(mat[1][1], mat[0][1]);
        if (N == 2)
            return Math.max(temp1, temp2);

        int temp3 = temp1 + Math.max(mat[0][2], mat[1][2]);
        if (N == 3)
            return Math.max(temp2, temp3);

        for (int i = 3; i < N; i++) {
            int ans = Math.max(temp1, temp2) + Math.max(mat[0][i], mat[1][i]);
            temp1 = temp2;
            temp2 = temp3;
            temp3 = ans;
        }
        return Math.max(temp2, temp3);
    }

    static int maxSum(int N, int mat[][]) {
        ///Using Memoization
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return Memoization(mat, 0, dp);

        //Using Tabulation
        // return Tabulation(mat);

        // Using Space Optimization
        // return SpaceOptimization(N, mat);
    }
}