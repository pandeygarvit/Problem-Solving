class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if (m * k > bloomDay.length) {return -1;}

        int n = bloomDay.length, maxDay = bloomDay[0];
        for (int i = 1; i < n; i++) {
            maxDay = (bloomDay[i] > maxDay) ? bloomDay[i] : maxDay;
        }

        int low = 1, high = maxDay, ans = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (check(bloomDay, m, k, mid) >= m) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }

        }

        return ans;

    }

    public int check(int[] bloomDay, int m, int k, int day) {

        int n = bloomDay.length, bouquetCount = 0, zeroCount = 0;

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = (bloomDay[i] - day >= 0) ? bloomDay[i] - day : 0;
        }

        for (int i = 0; i < n; i++) {

            if (temp[i] == 0) {
                zeroCount++;
            } else {
                zeroCount = 0;
            }

            if (zeroCount == k) {
                bouquetCount++;
                zeroCount = 0;
            }

        }

        return bouquetCount;

    }

}
