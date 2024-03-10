public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int findMin(int[] nums) {

        int low = 0, high = nums.length-1, ans = -1, n = nums.length;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (n == 1) {
                return nums[0];
            }

            if ((nums[mid] >= nums[low]) && (nums[mid] < nums[high])) {
                return nums[low];
            }

            if (nums[mid] >= nums[low]) { //left is sorted
                low = mid + 1;
                if (mid + 1 < n && nums[mid+1] < nums[mid]) {
                    return nums[mid+1];
                }
            }
            if (nums[mid] <= nums[high]) { //right is sorted
                high = mid - 1;
                if (mid - 1 > 0 && nums[mid-1] > nums[mid]) {
                    return nums[mid];
                }
            }
        }

        return ans;
    }

}