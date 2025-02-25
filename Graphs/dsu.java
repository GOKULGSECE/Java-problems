package Graphs;

class dsu {
    private static int[] parent;
    private static int[] rank;
    public static void dsu(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public static int find(int x)
    {
        if(parent[x]!=x)
        {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public static boolean union(int x,int y){
        int rootx = find(x);
        int rooty = find(y);
        if(rootx!=rooty)
        {
            if(rank[rooty]>rank[rootx])
            {
                parent[rootx] = rooty;
            }
            else if(rank[rootx]>rank[rooty])
            {
                parent[rooty] = rootx;
            }
            else{
                parent[rootx] = rooty;
                rank[rootx]++;
            }
        }
        else{
            return false;
        }
        return true;
    }
    public static int magnificentSets(int n, int[][] edges) {
        int result = 0;
        dsu(n);
        for(int []edge:edges)
        {
            if(union(edge[0]-1,edge[1]-1)){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int edges[][] = {{1,2},{2,3},{3,1}};
        int c = 3;
        System.out.println(magnificentSets(c,edges));
    }
}
//n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]