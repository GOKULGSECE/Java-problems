package Graphs;

import java.util.*;

class rottenorange {
        public static int bfs(Queue<int[]> qp, int[][] grid, boolean[][] visited) {
            int time = 0;
            // visited[i][j] = true;
            int row[] = {0, 0, -1, 1};
            int col[] = {-1, 1, 0, 0};
            while (!qp.isEmpty()) {
                int size = qp.size();
                boolean rot = false;
                for (int k = 0; k < size; k++) {
                    int curr[] = qp.poll();
                    int ce1 = curr[0];
                    int ce2 = curr[1];
                    for (int l = 0; l < 4; l++) {
                        int c1 = ce1 + row[l];
                        int c2 = ce2 + col[l];
                        if ((c1 >= 0 && c2 >= 0) && (c1 < grid.length && c2 < grid[0].length) && !visited[c1][c2] && grid[c1][c2] == 1) {
                            grid[c1][c2] = 2;
                            visited[c1][c2] = true;
                            qp.offer(new int[]{c1, c2});
                            rot = true;
                        }
                    }
                }
                if (rot) time++;

            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return time;
        }

        public static int orangesRotting(int[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            boolean visited[][] = new boolean[grid.length][grid[0].length];
            Queue<int[]> qp = new LinkedList<>();
            for (boolean[] c : visited) {
                Arrays.fill(c, false);
            }
            // visited[0][0] = true;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 2) {
                        qp.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            return bfs(qp, grid, visited);
        }
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
//[[2,1,1],[1,1,0],[0,1,1]]