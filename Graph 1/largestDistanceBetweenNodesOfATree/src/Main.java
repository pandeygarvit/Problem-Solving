import java.util.ArrayList;

public class Solution {
    public int solve(int[] A) {
        int N = A.length;
        ArrayList<Integer>[] adjacencyList = new ArrayList[N];
        int root = -1;

        for (int i = 0; i < N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            if (A[i] == -1) {
                root = i;
            } else {
                adjacencyList[A[i]].add(i);
                adjacencyList[i].add(A[i]);
            }
        }


        int[] furthestResult = findFurthestNode(adjacencyList, root);


        int[] secondFurthestResult = findFurthestNode(adjacencyList, furthestResult[1]);

        return secondFurthestResult[0];
    }

    private int[] findFurthestNode(ArrayList<Integer>[] adjacencyList, int start) {
        int N = adjacencyList.length;
        boolean[] visited = new boolean[N];
        return dfs(adjacencyList, start, visited, 0);
    }

    private int[] dfs(ArrayList<Integer>[] adjacencyList, int node, boolean[] visited, int depth) {
        visited[node] = true;
        int maxDepth = depth;
        int furthestNode = node;

        for (int adj : adjacencyList[node]) {
            if (!visited[adj]) {
                int[] result = dfs(adjacencyList, adj, visited, depth + 1);
                if (result[0] > maxDepth) {
                    maxDepth = result[0];
                    furthestNode = result[1];
                }
            }
        }
        visited[node] = false;
        return new int[] {maxDepth, furthestNode};
    }
}
