class Solution {
    public int minDistance(String word1, String word2) {


        int wordOneLength = word1.length();
        int wordTwoLength = word2.length();

        int[][] dp = new int[wordOneLength + 1][wordTwoLength + 1];

        for (int i = 1; i <= wordOneLength; i++)
            dp[i][0] = i;

        for (int j = 1; j <= wordTwoLength; j++)
            dp[0][j] = j;

        for (int i = 1; i <= wordOneLength; i++) {

            for (int j = 1; j <= wordTwoLength; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[wordOneLength][wordTwoLength];
    }
}