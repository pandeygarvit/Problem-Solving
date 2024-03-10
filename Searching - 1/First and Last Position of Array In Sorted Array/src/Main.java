public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                high = mid-1;
            } else if (nums[mid] < target) {
                low = mid+1;
            } else {
                ans[0] = mid;
                ans[1] = mid;
                while (ans[0] > 0 && nums[ans[0] - 1] == target) {
                    ans[0]--;
                }
                while (ans[1] < nums.length-1 && nums[ans[1] + 1] == target) {
                    ans[1]++;
                }

                break;
            }
        }

        return ans;
    }
}