import java.util.*;

public class Solution {

    public static int minTimeToRot(int[][] grid, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<OrangeInfo> q = new LinkedList<>();
        int countFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.offer(new OrangeInfo(i, j, 0));
                } else if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int minTime = 0;
        int[] rowFactor = {-1, 0, 1, 0};
        int[] colFactor = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            OrangeInfo processOrange = q.poll();
            int currentOrangeRow = processOrange.getRow();
            int currentOrangeCol = processOrange.getCol();
            int currentOrangeTime = processOrange.getTime();

            for (int i = 0; i < 4; i++) {
                int newRow = currentOrangeRow + rowFactor[i];
                int newCol = currentOrangeCol + colFactor[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                    visited[newRow][newCol] = true;
                    q.offer(new OrangeInfo(newRow, newCol, currentOrangeTime + 1));
                    minTime = currentOrangeTime + 1;
                    countFresh--;
                }
            }
        }

        if (countFresh > 0) {
            return -1;
        }

        return minTime;
    }
}

class OrangeInfo {
    private int row;
    private int col;
    private int time;

    public OrangeInfo(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getTime() {
        return time;
    }
}
