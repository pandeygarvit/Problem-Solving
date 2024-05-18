import java.util.Arrays;

class Solution {
    private static final int MOD = 1000000007;

    public int num(char c) {
        if (c == '*') return -1;
        return c - '0';
    }

    public int numDecodings(String s) {
        long[] mem = new long[s.length()];
        Arrays.fill(mem, -1);
        return (int) solve(s, 0, mem);
    }

    public long solve(String s, int index, long[] mem) {
        if (index >= s.length()) return 1;
        if (num(s.charAt(index)) == 0) return 0;
        if (mem[index] != -1) return mem[index];

        long ans = 0;

        // Single character decoding
        if (s.charAt(index) == '*') {
            ans += 9 * solve(s, index + 1, mem);  // '*' can be 1-9
            ans %= MOD;
        } else {
            ans += solve(s, index + 1, mem);  // regular digit
            ans %= MOD;
        }

        // Two characters decoding
        if (index + 1 < s.length()) {
            if (s.charAt(index) == '*') {
                if (s.charAt(index + 1) == '*') {
                    ans += 15 * solve(s, index + 2, mem);  // "**" can be 11-19, 21-26
                    ans %= MOD;
                } else {
                    int nextNum = num(s.charAt(index + 1));
                    if (nextNum >= 0 && nextNum <= 6) {
                        ans += 2 * solve(s, index + 2, mem);  // "*X" where X is 0-6 can be 10-16, 20-26
                        ans %= MOD;
                    } else {
                        ans += solve(s, index + 2, mem);  // "*X" where X is 7-9 can be 17-19
                        ans %= MOD;
                    }
                }
            } else if (s.charAt(index + 1) == '*') {
                if (num(s.charAt(index)) == 1) {
                    ans += 9 * solve(s, index + 2, mem);  // "1*" can be 11-19
                    ans %= MOD;
                } else if (num(s.charAt(index)) == 2) {
                    ans += 6 * solve(s, index + 2, mem);  // "2*" can be 21-26
                    ans %= MOD;
                }
            } else {
                int twoDigitNum = num(s.charAt(index)) * 10 + num(s.charAt(index + 1));
                if (twoDigitNum <= 26) {
                    ans += solve(s, index + 2, mem);  // regular two-digit number
                    ans %= MOD;
                }
            }
        }

        mem[index] = ans;
        return mem[index];
    }
}
