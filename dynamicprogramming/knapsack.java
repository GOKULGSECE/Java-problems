package dynamicprogramming;//{ Driver Code Starts
import java.io.IOException;

class GFG {
    public static void main(String[] args) throws IOException {
        int val[] = {1,2,3};
        int wt[] = {4,5,1};
        int c = 4;
        System.out.println(Solutions.knapSack(4,val,wt));
    }
}

// } Driver Code Ends


class Solutions {
    // Function to return max value that can be put in knapsack of capacity.
    static int recur(int cap,int size,int val[],int wt[],int [][]memo)
    {
        if(size<0)
        {
            return 0;
        }
        if(memo[size][cap]!=-1)return memo[size][cap];
        if(wt[size]>cap)
        {
            return memo[size][cap] = recur(cap,size-1,val,wt,memo);
        }
        return memo[size][cap] = Math.max(recur(cap,size-1,val,wt,memo),(val[size]+recur(cap-wt[size],size-1,val,wt,memo)));
    }
    static int knapSack(int capacity, int val[], int wt[]) {
        int size = val.length;
        int [][] memo = new int[size][capacity+1];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<capacity+1;j++)
            {
                memo[i][j] = -1;
            }
        }
        return recur(capacity,size-1,val,wt,memo);
    }
}
