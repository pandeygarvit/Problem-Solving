class Solution {

    public int maxScore(int[] cardPoints, int k) {
        // 0 1 2 3 4 5 6 7 k = 5
        int n = cardPoints.length;
        int j = 0;
        int currentSum = 0;
        for (int i = n - k; i < n; i++) {
            currentSum += cardPoints[i];
        }
        int ans = currentSum;
        for (int i = n - k; i < n; i++) {
            currentSum = currentSum - cardPoints[i] + cardPoints[j];
            ans = Math.max(ans, currentSum);
            j++;
        }
        return ans;
    }
}