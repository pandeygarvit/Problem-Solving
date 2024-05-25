class Solution {

    // tabulation
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] will be the length of longest common subsequence till ith in text1 and jth in text2
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

    // memoization

    // public int longestCommonSubsequence(String text1, String text2) {
    //   int[][] mem = new int[text1.length()][text2.length()];
    //   for (int i = 0; i < text1.length(); i++) {
    //     Arrays.fill(mem[i], -1);
    //   }

    //   return solve(text1, text2, 0, 0, mem);
    // }

    // public int solve(String text1, String text2, int i, int j, int[][] mem) {

    //   if (i >= text1.length() || j >= text2.length()) {
    //     return 0;
    //   }

    //   if (mem[i][j] != -1) {
    //     return mem[i][j];
    //   }

    //   if (text1.charAt(i) == text2.charAt(j)) {
    //     return mem[i][j] = 1 + solve(text1, text2, i + 1, j + 1, mem);
    //   } else {
    //     return mem[i][j] = (Math.max(
    //       solve(text1, text2, i + 1, j, mem),
    //       solve(text1, text2, i, j + 1, mem)
    //     ));
    //   }
    // }
}