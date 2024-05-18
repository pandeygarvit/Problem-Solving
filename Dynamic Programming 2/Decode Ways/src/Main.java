class Solution {
    public int num(char c) {
        return c - '0';
    }

    // tabulation

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        //dp[i] = represents number of ways string can be decoded from i to n - 1

        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0')  continue;
            dp[i] += dp[i + 1];
            if ((num(s.charAt(i)) * 10 + num(s.charAt(i + 1))) <= 26)  dp[i] += dp[i + 2];
        }

        return dp[0];
    }

    // memoization

    // public int numDecodings(String s) {

    //   int[] mem = new int[s.length()];
    //   Arrays.fill(mem, -1);

    //   return solve(s, 0, mem);
    // }

    // public int solve(String s, int index, int[] mem) {

    //   if (index >= s.length() - 1)  {
    //     if (index == s.length() - 1 && num(s.charAt(index)) == 0) return 0;
    //     return 1;
    //   }
    //   if (num(s.charAt(index)) == 0)  return 0;
    //   if (mem[index] != -1)  return mem[index];

    //   int ans = solve(s, index + 1, mem);
    //   if (index + 1 < s.length() && (num(s.charAt(index)) * 10 + num(s.charAt(index + 1)) <= 26)){
    //     ans += solve(s, index + 2, mem);
    //   }

    //   return mem[index] = ans;
    // }

}