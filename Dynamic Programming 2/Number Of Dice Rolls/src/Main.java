import java.util.Arrays;

class Solution {
    int mod = 1000000007;

    // space optimized

    public int numRollsToTarget(int n, int k, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // dp[i] = number of rolls required to reach target j with i dices (prev state)

        for (int i = 1; i <= n; i++) {
            int[] currdp = new int[target + 1];
            for (int j = 1; j <= target; j++) {
                for (int face = 1; face <= k && face <= j; face++) {
                    currdp[j] = (currdp[j] % mod + dp[j - face] % mod) % mod;
                }
            }
            // dp = currdp;
            dp = Arrays.copyOf(currdp, dp.length);
        }

        return dp[target];
    }

    // tabulation

    // public int numRollsToTarget(int n, int k, int target) {
    //   int[][] dp = new int[n + 1][target + 1];
    //   dp[0][0] = 1;
    //   // dp[i][j] = number of rolls required to reach target j with i dices

    //   for (int i = 1; i <= n; i++) {
    //     for (int j = 1; j <= target; j++) {
    //       for (int face = 1; face <= k && face <= j; face++) {
    //         dp[i][j] = (dp[i][j] % mod + dp[i - 1][j - face] % mod) % mod;
    //       }
    //     }
    //   }

    //   return dp[n][target];
    // }

    // memoization

    // public int numRollsToTarget(int n, int k, int target) {
    //   int[][] mem = new int[n + 1][target + 1];
    //   for (int i = 0; i < n + 1; i++) Arrays.fill(mem[i], -1);

    //   return memoization(n, k, target, mem);
    // }

    // public int memoization(int n, int k, int target, int[][] mem) {
    //   if (n == 0 && target == 0) return 1;
    //   if (n == 0 || target <= 0) return 0;

    //   if (mem[n][target] != -1) return mem[n][target];
    //   int ans = 0;
    //   for (int i = 1; i <= k; i++) {
    //     ans = (ans % mod + memoization(n - 1, k, target - i, mem) % mod) % mod;
    //   }

    //   return mem[n][target] = ans;
    // }

}