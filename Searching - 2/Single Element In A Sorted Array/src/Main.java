class Solution {
    public int singleNonDuplicate(int[] nums) {

        int low = 0, high = nums.length-1, n = nums.length;

        while (low <= high) {

            int mid = (low + high) / 2;

            if ((mid == n-1 || mid == 0)) {
                return nums[mid];
            }

            if ((mid + 1 < n) && (mid - 1 >= 0) && nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) {
                return nums[mid];
            }

            if (mid + 1 < n && nums[mid] == nums[mid+1]) {
                if (mid%2 == 0) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            }

            if (mid - 1 >= 0 && nums[mid] == nums[mid-1]) {
                if (mid%2 == 0) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            }

        }

        return -1;
    }
}