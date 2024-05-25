import java.util.Arrays;

class Solution {
    public int maximumScore(int[] nums, int[] muls) {
        int n = nums.length;
        int m = muls.length;
        int[][] memo = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        return solve(nums, muls, 0, 0, memo);
    }

    private int solve(int[] nums, int[] muls, int l, int i, int[][] memo) {
        if (i == muls.length) return 0;
        if (memo[l][i] != Integer.MIN_VALUE) return memo[l][i];

        int pickLeft = solve(nums, muls, l + 1, i + 1, memo) + nums[l] * muls[i];
        int pickRight = solve(nums, muls, l, i + 1, memo) + nums[nums.length - (i - l) - 1] * muls[i];

        return memo[l][i] = Math.max(pickLeft, pickRight);
    }
}
