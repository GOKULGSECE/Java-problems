package Graphs;
import java.util.*;
public class maxislands {
        public static int dfs(int[][] grid,int i,int j,boolean[][] visited)
        {
            if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]==0 || visited[i][j]){
                return 0;
            }
            // int ans = 0;
            visited[i][j] = true;
//            grid[i][j] = '0';
            int count =  1;
            count+=dfs(grid,i+1,j,visited);
            count+=dfs(grid,i-1,j,visited);
            count+=dfs(grid,i,j+1,visited);
            count+=dfs(grid,i,j-1,visited);
            return count;
        }
        public static int maxAreaOfIsland(int[][] grid)
        {
            int n = grid.length;
            int m = grid[0].length;
            boolean[][] visited = new boolean[n][m];
            int result = 0;
            for(boolean[] c:visited)
            {
                Arrays.fill(c,false);
            }
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(grid[i][j]==1 && !visited[i][j])
                    {
                        int maxicount = dfs(grid,i,j,visited);
                        result = Math.max(result,maxicount);
                    }
                }
            }
            return result;

        }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
    }
