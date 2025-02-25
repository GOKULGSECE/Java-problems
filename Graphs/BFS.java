package Graphs;

import java.util.Arrays;

class BFS {
    public static void bfs(int index, boolean[] visited, int[][] adj)
    {
        visited[index] = true;
        for(int l:adj[index])
        {
            if(!visited[l]){
                bfs(l,visited,adj);
            }
        }
    }
    public static int findCircleNum(int[][] isConnected)
    {
        int count = 0;
        boolean []visited = new boolean[isConnected.length];
        Arrays.fill(visited,false);
        for(int i=0;i<isConnected.length;i++)
        {
            if(!visited[i])
            {
                count++;
                bfs(i,visited,isConnected);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr));
    }
}