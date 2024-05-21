class Solution {

    // recursion

    public int maxSubArray(int[] nums) {
        return solve(nums, 0, false);
    }

    public int solve(int[] nums, int index, boolean mustPick) {

        if (index >= nums.length) {
            return mustPick ? 0 : Integer.MIN_VALUE;
        }

        if (mustPick) {
            return Math.max(0, nums[index] + solve(nums, index + 1, true));
        }

        return Math.max(solve(nums, index + 1, false), nums[index] + solve(nums, index + 1, true));
    }

    // tabulation

    // public int maxSubArray(int[] nums) {

    //   int n = nums.length;
    //   int[] dp = new int[n];
    //   // dp[i] = maximum sum subarray possible till ith index

    //   dp[0] = nums[0];
    //   int ans = dp[0];
    //   int currMax = Integer.MIN_VALUE;
    //   for (int i = 1; i < n; i++) {
    //     dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
    //     ans = Math.max(ans, dp[i]);
    //   }

    //   return n == 1 ? nums[0] : ans;
    // }


    // kadane's

    // public int maxSubArray(int[] nums) {

    //   int maxSoFar = Integer.MIN_VALUE;
    //   int sumSoFar = 0;

    //   for (int i = 0; i < nums.length; i++) {
    //     sumSoFar += nums[i];
    //     maxSoFar = Math.max(maxSoFar, sumSoFar);

    //     if (sumSoFar < 0) sumSoFar = 0;
    //   }

    //   return maxSoFar;
    // }

}