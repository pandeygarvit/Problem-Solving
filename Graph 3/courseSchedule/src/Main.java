import java.util.ArrayList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // only if it's a directed acyclic graph then we can find it's
        // topological sorting order

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        ArrayList<Integer>[] adjacencyList = adjacencyListGenerator(prerequisites, numCourses);
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i, visited, pathVisited, adjacencyList)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int node, boolean[] visited, boolean[] pathVisited, ArrayList<Integer>[] adjacencyList) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int adjNode: adjacencyList[node]) {
            if (!visited[adjNode]) {
                if (hasCycle(adjNode, visited, pathVisited, adjacencyList)) {
                    return true;
                }
            } else if (pathVisited[adjNode]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }

    private ArrayList<Integer>[] adjacencyListGenerator(int[][] edges,
                                                        int numVertex) {

        ArrayList<Integer>[] adjacencyList = new ArrayList[numVertex];
        for (int i = 0; i < numVertex; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            adjacencyList[edge[0]].add(edge[1]);
        }

        return adjacencyList;
    }
}