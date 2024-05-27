class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder supersequence = new StringBuilder();
        int i = n1, j = n2;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                supersequence.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                supersequence.append(str1.charAt(i - 1));
                i--;
            } else {
                supersequence.append(str2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            supersequence.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            supersequence.append(str2.charAt(j - 1));
            j--;
        }

        return supersequence.reverse().toString();
    }

    // recursive function for length of supersequence - untested

    // public int lengthOfSupersequence(int indexi, int indexj, String str1, String str2) {

    //   if (indexj >= str2.length() && indexi >= str1.length()) {
    //     return 0;
    //   } else if (indexj >= str2.length()) {
    //     return 1 + lengthOfSuperSequence(indexi + 1, indexj, str1, str2);
    //   } else if (indexi >= str1.length()) {
    //     return 1 + lengthOfSuperSequence(indexi, indexj + 1, str1, str2);
    //   }

    //   if (str1.charAt(indexi) == str2.charAt(indexj)) {
    //     return 1 + lengthOfSupersequence(indexi + 1, indexj + 1, str1, str2);
    //   } else {
    //     return Math.min(1 + lengthOfSupersequence(indexi + 1, indexj, str1, str2),
    //                     1 + lengthOfSupersequence(indexi, indexj + 1, str1, str2));
    //   }
    // }
}