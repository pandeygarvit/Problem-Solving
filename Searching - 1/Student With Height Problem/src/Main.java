public class Main
{
    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 5, 4, 3, 2};

        solve(arr, arr2);

    }

    public static void solve(int[] height, int[] check) {

        int nHeight = height.length, nCheck = check.length;

        for (int val : check) {

            int low = 0, high = nHeight - 1;

            while (low <= high) {

                int mid = (low + high) / 2;

                if (val > height[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }

            System.out.println(nHeight-low);

        }

    }


}