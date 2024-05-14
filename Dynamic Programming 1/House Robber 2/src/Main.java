import java.util.Arrays;

class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] mem = new int[n];
        Arrays.fill(mem, -1);
        int first = memoization(nums, 0, n - 2, mem);
        Arrays.fill(mem, -1);
        int second = memoization(nums, 1, n - 1, mem);
        return Math.max(first, second);
    }

    public int memoization(int[] nums, int index, int end, int[] mem) {

        if (index > end) return 0;

        if (mem[index] != -1) return mem[index];

        int notRob = memoization(nums, index + 1, end, mem);

        int rob = nums[index] + memoization(nums, index + 2, end, mem);

        return mem[index] = Math.max(rob, notRob);
    }
}