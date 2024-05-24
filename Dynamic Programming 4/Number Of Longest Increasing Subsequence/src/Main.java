import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // count of LIS ending at each index, initialized to 1
        int[] LISfreq = new int[n];
        Arrays.fill(LISfreq, 1);

        // length of LIS ending at each index
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        LISfreq[i] = LISfreq[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        LISfreq[i] += LISfreq[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                result += LISfreq[i];
            }
        }

        return result;
    }
}
