import java.util.ArrayList;

class Solution {

    // binary search

    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (arr.isEmpty() || nums[i] > arr.get(arr.size() - 1)) {
                arr.add(nums[i]);
            } else {
                if (arr.get(arr.size() - 1) > nums[i]) {
                    updateUpperBoundUsingBinarySearch(arr, nums[i]);
                }
            }
        }

        return (arr.size());
    }

    public void updateUpperBoundUsingBinarySearch(ArrayList<Integer> arr, int find) {
        int low = 0, high = arr.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) == find) {
                return;
            } else if (arr.get(mid) > find) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        arr.set(ans, find);
    }

    // tabulation

    // public int lengthOfLIS(int[] nums) {

    //   int n = nums.length;
    //   int[] dp = new int[n];
    //   dp[0] = 1;
    //   // dp[i] = length of longest strictly increasing subsequence till i

    //   for (int i = 1; i < n; i++) {
    //     int maxLISSizeEndingAti = 0;
    //     for (int j = 0; j < i; j++) {
    //       if (nums[i] > nums[j]) {
    //         maxLISSizeEndingAti = Math.max(dp[j], maxLISSizeEndingAti);
    //       }
    //     }
    //     dp[i] = maxLISSizeEndingAti + 1;
    //   }

    //   return dp[n - 1];
    // }

    // space optimized memoization

    // public int lengthOfLIS(int[] nums) {
    //   int[] mem = new int[nums.length + 1];
    //   Arrays.fill(mem, -1);

    //   return solve(nums, 0, -1, mem);
    // }

    // public int solve(int[] nums, int index, int prevIndex, int[] mem) {

    //   if (index >= nums.length) {
    //     return 0;
    //   }

    //   if (mem[prevIndex + 1] != -1) {
    //     return mem[prevIndex + 1];
    //   }

    //   int take = 0;

    //   if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
    //     take = 1 + solve(nums, index + 1, index, mem);
    //   }

    //   int dontTake = solve(nums, index + 1, prevIndex, mem);

    //   return mem[prevIndex + 1] = Math.max(take, dontTake);
    // }

    // memoization

    // public int lengthOfLIS(int[] nums) {
    //   int[][] mem = new int[nums.length][nums.length + 1];
    //   for (int i = 0; i < nums.length; i++) {
    //     Arrays.fill(mem[i], -1);
    //   }
    //   return solve(nums, 0, -1, mem);
    // }

    // public int solve(int[] nums, int index, int prevIndex, int[][] mem) {
    //   if (index >= nums.length) {
    //     return 0;
    //   }

    //   if(mem[index][prevIndex + 1] != -1) {
    //     return mem[index][prevIndex + 1];
    //   }

    //   int take = 0;
    //   if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
    //     take = 1 + solve(nums, index + 1, index, mem);
    //   }
    //   int dontTake = solve(nums, index + 1, prevIndex, mem);

    //   return mem[index][prevIndex + 1] = Math.max(take, dontTake);
    // }

}