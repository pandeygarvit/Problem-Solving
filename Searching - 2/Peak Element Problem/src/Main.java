class Solution {
    public int findPeakElement(int[] nums) {

        int n = nums.length, high = n-1, low = 0, ans;
        if (n == 1) { return 0; }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[n-1] > nums[n-2]) {
            return n-1;
        }


        while (low <= high) {

            int mid = (low + high) / 2;

            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }


            if (nums[mid+1] >= nums[mid]) {
                low = mid;
            } else if (nums[mid-1] >= nums[mid]) {
                high = mid;
            }

        }
        return -1;
    }
}