public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int findKRotation(int []arr){

        int low = 0, high = arr.length-1, n = arr.length-1, minimumIntegerIndex = 0;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] >= arr[low] && arr[mid] <= arr[high]) {
                minimumIntegerIndex = low;
                return minimumIntegerIndex;
            }

            if (arr[mid] >= arr[low]) { //left is sorted
                if (mid + 1 < n && arr[mid + 1] < arr[mid]) {
                    minimumIntegerIndex = mid + 1;
                    return minimumIntegerIndex;
                }
                low = mid + 1;
            }

            if (arr[mid] <= arr[high]) { //right is sorted
                if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) {
                    minimumIntegerIndex = mid;
                    return minimumIntegerIndex;
                }
                high = mid - 1;
            }
        }
        return 0;

    }
}