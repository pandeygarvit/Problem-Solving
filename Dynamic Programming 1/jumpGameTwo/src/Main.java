class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 10001;
        }
        dp[n-1] = 0;

        for (int i = n-2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[Math.min(n-1, i+j)]);
            }
        }

        return dp[0];
    }

    // public int jump(int[] nums) {
    //   int[] dp = new int[nums.length];
    //   for (int i = 0; i < nums.length; i++) {
    //     dp[i] = 10001;
    //   }
    //   return solve(nums, dp, 0);
    // }

    // private int solve(int[] nums, int[] dp, int pos) {
    //   if (pos >= nums.length - 1) {
    //     return 0;
    //   }
    //   if (dp[pos] != 10001) {
    //     return dp[pos];
    //   }
    //   for (int i = 1; i <= nums[pos]; i++) {
    //     dp[pos] = Math.min(dp[pos], 1 + solve(nums, dp, pos + i));
    //   }

    //   return dp[pos];
    // }

    // public int jump(int[] nums) {
    //   if (nums.length == 1) {
    //     return 0;
    //   }
    //   int[] minJump = {10001};
    //   solve(nums, 0, minJump);
    //   return minJump[0];
    // }

    // private int solve(int[] nums, int pos, int[] minJump) {
    //   if (pos >= nums.length - 1) {
    //     return 0;
    //   }
    //   for (int i = 1; i <= nums[pos]; i++) {
    //     minJump[0] = Math.min(minJump[0], 1 + solve(nums, pos+i, minJump));
    //   }
    //   return minJump[0];
    // }
}