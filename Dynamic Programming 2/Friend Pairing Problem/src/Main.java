class Solution
{
    int mod = 1000000007;
    public long countFriendsPairings(int n) {
        long[] dp = new long[n + 1];

        dp[1] = 1;
        if (n == 1) return 1;
        dp[2] = 2;
        if (n == 2) return 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (i - 1) * dp[i - 2] % mod) % mod;
        }

        return dp[n];
    }

    // public long countFriendsPairings(int n) {
    //   //code here
    //   long[] mem = new long[n + 1];
    //   Arrays.fill(mem, -1);
    //   return memoization(n, mem);
    // }

    // public long memoization(int n, long[] mem) {
    //     if (n <= 2) return n;
    //     if (mem[n] != -1) return mem[n];
    //     return mem[n] = memoization(n - 1, mem) + (n - 1) * memoization (n - 2, mem);
    // }
}    