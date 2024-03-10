public class Main {
    public static void main(String[] args) {
        
    }
    public boolean search(int[] arr, int target) {

        int low = 0, high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return true;
            }

            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (arr[low] <= arr[mid]) { //left is sorted
                if (target <= arr[mid] && target >= arr[low]) { //element exists in this range
                    high = mid - 1;
                } else { //element DNE in the above mentioned if case range
                    low = mid + 1;
                }
            }

            if (arr[high] >= arr[mid]) { //right is sorted
                if (target >= arr[mid] && target <= arr[high]) { //element exists in this range
                    low = mid + 1;
                } else { //element DNE in the above mentioned if case range
                    high = mid - 1;
                }
            }

        }

        return false;

    }

}