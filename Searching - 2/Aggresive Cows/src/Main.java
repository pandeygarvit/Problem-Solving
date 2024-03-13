import java.util.*;
public class Solution {
    public static int aggressiveCows(int []stalls, int k) {

        Arrays.sort(stalls);

        int n = stalls.length;
        int low = 1, high = stalls[n-1]-stalls[0], ans = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (canWePlace(k, stalls, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return ans;
    }

    public static boolean canWePlace(int k, int stalls[], int distance) {

        int lastCowPlacedAt = stalls[0], placedCowCount = 1, n = stalls.length;

        for (int i = 1; i < n; i++) {

            if (stalls[i] - lastCowPlacedAt >= distance) {
                lastCowPlacedAt = stalls[i];
                placedCowCount++;
            }

        }

        return (placedCowCount >= k) ? true : false;
    }

}