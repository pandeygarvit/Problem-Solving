import java.util.ArrayList;
import java.util.List;

class DSU {
    private List<Integer> parent;
    private List<Integer> rank;

    DSU(int numNodes) {
        parent = new ArrayList<>(numNodes);
        rank = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            parent.add(i);
            rank.add(1);
        }
    }

    public int find(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int p = find(parent.get(node));
        parent.set(node, p);
        return p;
    }

    public boolean union(int u, int v) {
        int p1 = find(u);
        int p2 = find(v);

        if (p1 == p2) {
            return false;
        }

        if (rank.get(p1) <= rank.get(p2)) {
            parent.set(p1, p2);
            rank.set(p2, rank.get(p2) + rank.get(p1));
        } else {
            parent.set(p2, p1);
            rank.set(p1, rank.get(p1) + rank.get(p2));
        }
        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int numNodes = edges.length;
        DSU dsu = new DSU(numNodes + 1);
        for (int[] edge : edges) {
            boolean isUnionPossible = dsu.union(edge[0], edge[1]);
            if (!isUnionPossible) {
                return edge;
            }
        }
        return new int[0];
    }
}
