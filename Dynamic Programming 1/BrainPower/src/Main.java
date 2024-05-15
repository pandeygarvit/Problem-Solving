class Solution {

    public long mostPoints(int[][] questions) {
        long ans = 0;
        int n = questions.length;
        long[] dp = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            int brainpower = questions[i][1];
            dp[i] = Math.max(i + 1 >= n ? 0 : dp[i + 1],
                    questions[i][0] +
                            (i + brainpower + 1 >= n ? 0 : dp[i + brainpower + 1]));
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    // Memoization

    // public long mostPoints(int[][] questions) {
    //   long[] mem = new long[questions.length];
    //   Arrays.fill(mem, -1);
    //   return memoization(questions, 0, mem);
    // }

    // public long memoization(int[][] questions, int index, long[] mem) {

    //   if (index >= questions.length) return 0;

    //   if (mem[index] != -1) return mem[index];

    //   int brainpower = questions[index][1];
    //   long take = (long) questions[index][0] + memoization(questions, index + brainpower + 1, mem);
    //   long notTake = memoization(questions, index + 1, mem);

    //   return mem[index] = Math.max(take, notTake);
    // }
}