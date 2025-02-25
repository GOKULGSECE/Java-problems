package Graphs;

public class unionset {
    private static int [] parent;
    private static int [] rank;
    public static void dsu(int n,int[][] edges)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] i:edges)
        {
            union(i[0],i[1]);
        }
        // return find(source) == find(destination);
    }
    public static int find(int x)
    {
        if(parent[x]!=x)
        {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public static boolean union(int x, int y)
    {
        int rx = find(x);
        int ry = find(y);
        if(rx!=ry){ //if they are equal means they form as reduntant edges so union of this sets is not possible{if they already have same parent means no need to checking as they already belong to same set}
            if(rank[rx]>rank[ry])
            {
                parent[ry] = rx;
            }
            else if(rank[rx]<rank[ry])
            {
                parent[rx] = ry;
            }
            else{
                parent[ry] = rx;
                rank[ry]++;
            }
        }else{
            return false;
        }
        return true;
    }
    public static int countComponents(int n, int[][] edges) {
        dsu(n,edges);
        int result = n;
        for(int arr[]:edges)
        {
            if(union(arr[0],arr[1])){
                result--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[][]={{0,1},{0,2}};
        int k = 3;
        System.out.println(countComponents(k,arr));
    }
}
