class Solution {

    // 1 2 3 4 5
    // target = 9
    // 1
    // 2
    // 3
    // 4

    // tabulation
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        // nums was weight
        // contribution if picked was 1
        // target was capacity
        // similar to coin change

        dp[0] = 0; // to create target = 0, we will need 0 longest subsequence

        for (int i = 0; i < nums.size(); i++) {
            // we are processing a particular coin
            for (int j = target; j >= 0; j--) {
                // for the particular coin, we will see the longest subsequence to sum to target j
                if (j - nums.get(i) >= 0 && dp[j - nums.get(i)] != Integer.MIN_VALUE) {
                    dp[j] = Math.max(1 + dp[j - nums.get(i)], dp[j]);
                }
            }
        }

        return (dp[target] == Integer.MIN_VALUE ? -1 : dp[target]);
    }

    // memoization

    // public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
    //   int[][] mem = new int[nums.size()][target + 1];
    //   for (int i = 0; i < nums.size(); i++) {
    //     Arrays.fill(mem[i], -1);
    //   }
    //   int result = solve(nums, 0, target, mem);
    //   return result == Integer.MIN_VALUE ? -1 : result;
    // }

    // public int solve(List<Integer> nums, int index, int target, int[][] mem) {
    //   if (target == 0) {
    //     return 0;
    //   } else if (index >= nums.size() || target < 0) {
    //     return Integer.MIN_VALUE;
    //   }

    //   if (mem[index][target] != -1) {
    //     return mem[index][target];
    //   }

    //   int take = 1 + solve(nums, index + 1, target - nums.get(index), mem);
    //   take = (take == Integer.MIN_VALUE + 1) ? Integer.MIN_VALUE : take;

    //   int notTake = solve(nums, index + 1, target, mem);

    //   return mem[index][target] = Math.max(take, notTake);
    // }
}
