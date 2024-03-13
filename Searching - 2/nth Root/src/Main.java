public class Solution {
    public static int NthRoot(int n, int m) {

        // Brute force logic
        // int ans = (int) Math.pow ((double) m, (double) 1/n);
        // if (Math.pow((double) ans, (double) n) == (double) m) {
        //     return ans;
        // } else {
        //     return -1;
        // }


        // O(mn) solution
        // for (int i = 1  ; i < m; i++) {

        //     int iToThePowerN = 1;
        //     for (int j = 1; j <= n; j++) {
        //         iToThePowerN = iToThePowerN * i;
        //     }

        //     if (iToThePowerN == m) {
        //         return i;
        //     }
        // }

        // return -1;

        // Binary search optimization

        int low = 1, high = m;

        while (low <= high) {

            int mid = (low + high) / 2;
            int temp = check(mid, n, m);

            if (temp == 0) { return mid;}
            else if (temp == 1) { low = mid + 1;}
            else { high = mid - 1;}
        }

        return -1;

    }

    public static int check (int base, int exp, int value) {

        //returns 0 if value is equal to base to the power of exp
        //returns 1 if value is less than base to the power of exp
        //returns 2 if value is more than base to the power of exp

        long ans = 1;

        for (int i = 0; i < exp; i++) {
            ans = ans * ((long) base);
            if (ans > value) {  return 2;}
        }

        if ((long) value == ans) {
            return 0;
        }
        return 1;
    }
}
