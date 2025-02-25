package recursion;

class Maze {
    public static void findPaths(int m, int n, String path, int[][] maze) {
        // Base case: reached the top-left corner (0, 0)
        if (m == 0 && n == 0) {
            path += "END";
            System.out.println(path);
            return;
        }

        // Move UP if within bounds and not blocked
        if (m > 0 && maze[m - 1][n] != 1) {
            findPaths(m - 1, n, path + "UP->", maze);
        }
        if (n > 0 && maze[m][n - 1] != 1) {
            findPaths(m, n - 1, path + "LEFT->", maze);
        }
        if (m > 0 && n > 0 && maze[m - 1][n - 1] != 1) {
            findPaths(m - 1, n - 1, path + "DIAGONAL->", maze);
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] maze = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        findPaths(m - 1, n - 1, "", maze);
    }
}
