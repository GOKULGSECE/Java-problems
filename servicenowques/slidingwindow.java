package servicenowques;

import java.util.*;

public class slidingwindow {
    public static int check(int[] arr,int k)
    {
        Map<Integer,Integer> mp = new HashMap<>();
        int i=0;
//        res.add(arr[i]);
        int maxiLen = Integer.MAX_VALUE;
        for(int j=0;j<arr.length;j++)
        {
                 mp.put(arr[j],mp.getOrDefault(arr[j],0)+1);
                while(mp.size()==k)
                {
                    maxiLen = Math.min(maxiLen,j-i+1);
                    mp.put(arr[i],mp.get(arr[i])-1);
                    if(mp.get(arr[i])==0) mp.remove(arr[i]);
                    i++;
                }
        }
        return maxiLen;
    }
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,3};
        int k = 3;
        System.out.println(check(arr,k));


    }
}
