import java.util.ArrayList;

class Solution {
    public int findCircleNum(int[][] isConnected) {

        int count = 0;

        ArrayList<Integer>[] adjacencyList = adjacencyListGenerator(isConnected);
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                visited[i] = true;
                dfs(i, adjacencyList, visited);
            }
        }

        return count;
    }

    public void dfs(int node, ArrayList<Integer>[] adjacencyList, boolean[] visited) {

        for (int adjNode : adjacencyList[node]) {
            if (!visited[adjNode]){
                visited[adjNode] = true;
                dfs(adjNode, adjacencyList, visited);
            }
        }

    }

    private ArrayList<Integer>[] adjacencyListGenerator(int[][] isConnected) {
        ArrayList<Integer>[] adjacencyList = new ArrayList[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    int nodeOne = i;
                    int nodeTwo = j;

                    adjacencyList[nodeOne].add(nodeTwo);
                    adjacencyList[nodeTwo].add(nodeOne);
                }
            }
        }

        return adjacencyList;
    }
}