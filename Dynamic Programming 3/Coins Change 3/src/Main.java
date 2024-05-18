class Solution {

    // space optimization

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];

        // dp[i] = number of combinations that can be formed to reach amount amt with coins[]
        dp[0] = 1; // when amount is 0 a combination has been achieved
        for (int i = 0; i < coins.length; i++) {
            for (int amt = 1; amt <= amount; amt++) {
                if (amt - coins[i] >= 0) dp[amt] += dp[amt - coins[i]];
            }
        }

        return dp[amount];
    }

    // tabulation

    // public int change(int amount, int[] coins) {
    //   int n = coins.length;
    //   int[][] dp = new int[n+1][amount + 1];

    //   //dp[i][j] = Number of combinations possible for ith to n - 1 number(index) of coins which can form j amount

    //   for (int i = 0; i <= n; i++)  dp[i][0] = 1;

    //   for (int i = 1; i <= n; i++) {
    //     for (int amt = 1; amt <= amount; amt++) {
    //       dp[i][amt] = dp[i - 1][amt]; // the i-1th index coin was skipped
    //       if (amt - coins[i - 1] >= 0) dp[i][amt] += dp[i][amt - coins[i - 1]]; //the i-1th index coin was picked
    //     }
    //   }

    //   return dp[coins.length][amount];
    // }

    // memoization

    // public int change(int amount, int[] coins) {
    //   int[][] mem = new int[coins.length][amount + 1];
    //   for (int i = 0; i < coins.length; i++)  Arrays.fill(mem[i], -1);
    //   return memoization(0, amount, coins, mem);
    // }

    // public int memoization(int index, int amount, int[] coins, int[][] mem) {
    //   if (amount == 0)  return 1;
    //   if (amount < 0 || index >= coins.length)  return 0;

    //   if (mem[index][amount] != -1)  return mem[index][amount];

    //   int take = memoization(index, amount - coins[index], coins, mem);
    //   int notTake = memoization(index + 1, amount, coins, mem);

    //   return mem[index][amount] = take + notTake;
    // }
}