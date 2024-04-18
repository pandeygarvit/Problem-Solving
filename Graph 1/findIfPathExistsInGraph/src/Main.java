import java.util.ArrayList;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] adjacencyList = adjacencyListGenerator(edges, n);

        boolean[] visited = new boolean[n];

        visited[source] = true;
        return solveDFS(source, adjacencyList, visited, destination);

    }

    public boolean solveDFS(int node, ArrayList<Integer>[] adjacencyList, boolean[] visited, int target) {
        if (node == target) {
            return true;
        }

        for (int adjNode : adjacencyList[node]){
            if (!visited[adjNode]) {
                visited[adjNode] = true;
                boolean hasTarget = solveDFS(adjNode, adjacencyList, visited, target);
                if (hasTarget == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Integer>[] adjacencyListGenerator(int[][] edges, int numberOfVertices) {

        ArrayList<Integer>[] ans = new ArrayList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            ans[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int nodeOne = edges[i][0];
            int nodeTwo = edges[i][1];

            ans[nodeOne].add(nodeTwo);
            ans[nodeTwo].add(nodeOne);
        }

        return ans;
    }
}