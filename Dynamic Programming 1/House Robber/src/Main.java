class Solution {

    public int rob(int[] nums) { // space optimised tabulation
        int n = nums.length;
        if (n == 1) return nums[0];

        int secondPrev = 0, prev = 0, curr = 0;
        for (int num : nums) {
            curr = Math.max(prev, num + secondPrev);
            secondPrev = prev;
            prev = curr;
        }

        return curr;
    }

    // public int rob(int[] nums) {
    // for tabulation
    //   int n = nums.length;
    //   if (n == 1) return nums[0];

    //   int[] dp = new int[n];
    //   dp[0] = nums[0];
    //   dp[1] = Math.max(nums[0], nums[1]);

    //   for (int i = 2; i < n; i++) {
    //     dp[i] = Math.max(dp[i-1], nums[i] + dp[i - 2]);
    //   }

    //   return dp[n - 1];

    //memoization
    // int[] mem = new int[nums.length];
    // Arrays.fill(mem, -1);

    // return memoization(nums, 0, mem);
    // }

    public int memoization(int[] nums, int index, int[] mem) {

        if (index >= nums.length) return 0;

        if (mem[index] != -1) return mem[index];

        int notRob = memoization(nums, index + 1, mem);
        int rob = nums[index] + memoization(nums, index + 2, mem);

        return mem[index] = Math.max(rob, notRob);
    }
}