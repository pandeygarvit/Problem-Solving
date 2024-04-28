import java.util.*;
class Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
            ans.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjacencyList[edges[i][0]].add(edges[i][1]);
        }

        for (int node = 0; node < n; node++) {
            boolean[] visited = new boolean[n];
            for (int adj: adjacencyList[node]) {
                dfs(adj, node, adjacencyList, visited, ans);
            }
        }

        return ans;
    }

    public void dfs(int node, int source, ArrayList<Integer>[] adjacencyList, boolean[] visited, List<List<Integer>> ans) {
        visited[node] = true;
        for (int adj: adjacencyList[node]) {
            if (!visited[adj]) {
                dfs(adj, source, adjacencyList, visited, ans);
            }
        }
        if (!ans.get(node).contains(source)) {
            ans.get(node).add(source);
        }
    }
    // public List<List<Integer>> getAncestors(int n, int[][] edges) {
    //   ArrayList<Integer>[] adjacencyList = adjacencyListGenerator(n, edges);

    //   List<List<Integer>> ans = new ArrayList<>();
    //   for (int i = 0; i < n; i++) {
    //     ans.add(new ArrayList<>());
    //   }

    //   for (int node = 0; node < n; node++) {
    //     dfs(node, -1, adjacencyList, ans);
    //   }

    //   for (int i = 0; i < n; i++) {
    //     Collections.sort(ans.get(i));
    //   }
    //   return ans;
    // }

    // private void dfs(int node, int parent, ArrayList<Integer>[] adjacencyList, List<List<Integer>> ans) {
    //   if (parent != -1) {
    //     if (!ans.get(node).contains(parent)) {
    //       ans.get(node).add(parent);
    //     }
    //     for (int parentListNode: ans.get(parent)) {
    //       if (!ans.get(node).contains(parentListNode)) {
    //         ans.get(node).add(parentListNode);
    //       }
    //     }
    //   }
    //   for (int adj: adjacencyList[node]) {
    //     dfs(adj, node, adjacencyList, ans);
    //   }
    // }

    // private ArrayList<Integer>[] adjacencyListGenerator(int n, int[][] edges) {
    //   ArrayList<Integer>[] adjacencyList = new ArrayList[n];
    //   for (int i = 0; i < n; i++) {
    //     adjacencyList[i] = new ArrayList<>();
    //   }

    //   for (int[] edge: edges) {
    //     adjacencyList[edge[0]].add(edge[1]);
    //   }
    //   return adjacencyList;
    // }
}