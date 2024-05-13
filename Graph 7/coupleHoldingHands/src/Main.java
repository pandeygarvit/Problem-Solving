import java.util.Arrays;

class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n, int[] row) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 2);
        for (int i = 0; i < n; i += 2) {
            parent[row[i]] = row[i];
            parent[row[i + 1]] = row[i];
        }
    }

    public int findParent(int i) {
        int x = parent[i];
        while (parent[x] != x) {
            x = parent[x];
        }
        return parent[i] = x;
    }

    public boolean join(int i, int j) {
        int pi = findParent(i);
        int pj = findParent(j);
        if (pi == pj)
            return false;
        if (rank[pi] <= rank[pj]) {
            parent[pi] = pj;
            rank[pj] += rank[pi];
        } else {
            parent[pj] = pi;
            rank[pi] += rank[pj];
        }
        return true;
    }
}

class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        DSU dsu = new DSU(n, row);
        int swaps = 0;
        for (int i = 0; i < n; i += 2) {
            if (dsu.join(i, i + 1))
                swaps++;
        }
        return swaps;
    }
}
