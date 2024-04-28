class Solution {
    public int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        // for 1 step -> 1 way
        // for 2 step -> 2 way
        // for next step -> prev way + prev-1 way

        int oneBefore = 2;
        int twoBefore = 1;
        int total = 0;
        for (int i = 3; i <= n; i++) {
            total = oneBefore + twoBefore;
            twoBefore = oneBefore;
            oneBefore = total;
        }

        return total;
    }
}