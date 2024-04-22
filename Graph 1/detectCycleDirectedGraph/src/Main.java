class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, pathVisited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int node, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adj) {
        if (visited[node]) {
            return true;
        }
        visited[node] = true;
        pathVisited[node] = true;
        for (int adjNode : adj.get(node)) {

            if (!visited[adjNode]) {
                if (dfs(adjNode, visited, pathVisited, adj)) {
                    return true;
                }

            } else if (pathVisited[adjNode]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}

