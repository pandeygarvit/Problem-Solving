class Solution {
    public boolean hasValidPath(int[][] grid) {
        // can go up
        // 2 3 4 TO ?
        // can go down
        // 2 5 6 TO ?
        // can go right from
        // 1 4 6 TO ?
        // can go left from
        // 1 3 5 TO ?

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        dfs(0, 0, grid, visited);
        return visited[grid.length - 1][grid[0].length - 1];
    }

    public void dfs(int row, int col, int[][] grid, boolean[][] visited) {

        visited[row][col] = true;
        int newRow, newCol;

        if (grid[row][col] == 1 || grid[row][col] == 4 || grid[row][col] == 6) {
            newRow = row;
            newCol = col + 1;

            if (isValid(newRow, newCol, grid, visited) && (grid[newRow][newCol] == 1 || grid[newRow][newCol] == 3 || grid[newRow][newCol] == 5)) {
                dfs(newRow, newCol, grid, visited);
            }
        }

        if (grid[row][col] == 1 || grid[row][col] == 3 || grid[row][col] == 5) {
            newRow = row;
            newCol = col - 1;

            if (isValid(newRow, newCol, grid, visited) && (grid[newRow][newCol] == 1 || grid[newRow][newCol] == 4 || grid[newRow][newCol] == 6)) {
                dfs(newRow, newCol, grid, visited);
            }
        }
        if (grid[row][col] == 2 || grid[row][col] == 3 || grid[row][col] == 4) {
            newRow = row + 1;
            newCol = col;

            if (isValid(newRow, newCol, grid, visited) && (grid[newRow][newCol] == 2 || grid[newRow][newCol] == 5 || grid[newRow][newCol] == 6)) {
                dfs(newRow, newCol, grid, visited);
            }
        }

        if (grid[row][col] == 2 || grid[row][col] == 5 || grid[row][col] == 6) {
            newRow = row - 1;
            newCol = col;

            if (isValid(newRow, newCol, grid, visited) && (grid[newRow][newCol] == 2 || grid[newRow][newCol] == 3 || grid[newRow][newCol] == 4)) {
                dfs(newRow, newCol, grid, visited);
            }
        }
    }

    public boolean isValid(int newRow, int newCol, int[][] grid, boolean[][] visited) {
        if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && !visited[newRow][newCol]) {
            return true;
        }
        return false;
    }
}