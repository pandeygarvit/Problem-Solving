import java.util.Arrays;

class Solution {
    public boolean isMatch(String s, String p) {
        int[][] mem = new int[s.length() + 1][p.length() + 1];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i], -1);
        }

        return isMatching(s, p, 0, 0, mem) == 1;
    }

    public int isMatching(String text, String pattern, int texti, int patternj, int[][] mem) {
        if (mem[texti][patternj] != -1) {
            return mem[texti][patternj];
        }

        if (texti == text.length() && patternj == pattern.length()) {
            return mem[texti][patternj] = 1;
        } else if (patternj == pattern.length()) {
            return mem[texti][patternj] = 0;
        } else if (texti == text.length()) {
            return mem[texti][patternj] = pattern.charAt(patternj) == '*' && isMatching(text, pattern, texti, patternj + 1, mem) == 1 ? 1 : 0;
        }

        char textChar = text.charAt(texti);
        char patternChar = pattern.charAt(patternj);

        if (patternChar == textChar || patternChar == '?') {
            mem[texti][patternj] = isMatching(text, pattern, texti + 1, patternj + 1, mem);
        } else if (patternChar == '*') {
            mem[texti][patternj] = (isMatching(text, pattern, texti, patternj + 1, mem) == 1 ||
                    isMatching(text, pattern, texti + 1, patternj, mem) == 1) ? 1 : 0;
        } else {
            mem[texti][patternj] = 0;
        }

        return mem[texti][patternj];
    }
}
