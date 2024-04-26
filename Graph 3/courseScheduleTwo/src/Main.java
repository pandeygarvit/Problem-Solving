import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer>[] adjacencyList = adjacencyListGenerator(prerequisites, numCourses);

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, adjacencyList, st)) {
                    return new int[]{};
                };
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }

    public ArrayList<Integer>[] adjacencyListGenerator(int[][] edges, int numVertex) {
        ArrayList<Integer>[] adjacencyList = new ArrayList[numVertex];

        for (int i = 0; i < numVertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int edge[]: edges) {
            adjacencyList[edge[1]].add(edge[0]);
        }

        return adjacencyList;
    }

    public boolean dfs(int node, boolean[] visited, boolean[] pathVisited, ArrayList<Integer>[] adjacencyList, Stack<Integer> st) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int adjNode: adjacencyList[node]) {
            if (!visited[adjNode]) {
                if (dfs(adjNode, visited, pathVisited, adjacencyList, st)) {
                    return true;
                }
            } else if (pathVisited[adjNode]) {
                return true;
            }
        }
        pathVisited[node] = false;
        st.push(node);
        return false;
    }
}