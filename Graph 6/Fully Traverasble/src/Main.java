import java.util.Arrays;

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> (b[0] - a[0]));
        int[] rootsAlice = new int[n + 1];
        int[] rootsBob = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            rootsAlice[i] = i;
            rootsBob[i] = i;
        }
        int componentsAlice = n, componentsBob = n;
        int result = 0;
        for (int[] e : edges) {
            if (e[0] == 1) {
                int rootA = find(e[1], rootsAlice);
                int rootB = find(e[2], rootsAlice);
                if (rootA == rootB) {
                    result++;
                } else {
                    rootsAlice[rootA] = rootB;
                    componentsAlice--;
                }
            } else if (e[0] == 2) {
                int rootA = find(e[1], rootsBob);
                int rootB = find(e[2], rootsBob);
                if (rootA == rootB) {
                    result++;
                } else {
                    rootsBob[rootA] = rootB;
                    componentsBob--;
                }
            } else {
                int rootA1 = find(e[1], rootsAlice);
                int rootB1 = find(e[2], rootsAlice);
                int rootA2 = find(e[1], rootsBob);
                int rootB2 = find(e[2], rootsBob);
                if (rootA1 != rootB1) {
                    rootsAlice[rootA1] = rootB1;
                    componentsAlice--;
                }
                if (rootA2 != rootB2) {
                    rootsBob[rootA2] = rootB2;
                    componentsBob--;
                }
                if (rootA1 == rootB1 && rootA2 == rootB2) {
                    result++;
                }
            }
        }
        if (componentsAlice != 1 || componentsBob != 1) return -1;
        return result;
    }

    private int find(int i, int[] roots) {
        int j = i;
        while (roots[i] != i) {
            i = roots[i];
        }
        roots[j] = i;
        return i;
    }
}
