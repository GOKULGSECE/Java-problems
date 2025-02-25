import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class Main {
    private double mod = 1e9 + 7;
    private static ArrayList<Integer> primes = new ArrayList<>();

    private static void sieve() {
        boolean[] check = new boolean[1000000001];
        Arrays.fill(check, true);
        check[0] = false;
        check[1] = false;
        for (int i = 2; i * i <= 1000000000; i++) {
            if (check[i]) {
                for (int p = i * i; p <= 1000000000; p += i) {
                    check[p] = false;
                }
            }
        }
        for (int i = 2; i < 1000000000; i++) {
            if (check[i]) {
                primes.add(i);
            }
        }
    }

    private static int[] reverse(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            s++;
            e--;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[] = new int[]{1,0,1,0,1};

    }


//    public static int minimumSumSubarray(List<Integer> nums, int k) {
//        List<Integer> res = new ArrayList<>();
//        int i=0;
//        int j=i+1;
//        int resi =0;
//        int sum = 0;
//        sum+=nums.get(i);
//        while(j<nums.size())
//        {
//            sum+=nums.get(j);
//            if(sum>k)
//            {
//                sum-=nums.get(i);
//                i++;
//            }
//            if(sum==k)
//            {
//                resi++;
//                sum-=nums.get(i);
//                i++;
//            }
//            j++;
//        }
//        return resi;
//
//    }
//    public static int maxScore(int[] cardPoints, int k) {
//        int lsum = 0;
//        int rsum = 0;
//        for(int i=0;i<k;i++)
//        {
//            lsum+=cardPoints[i];
//        }
//        int maxi = lsum;
//        int lind = cardPoints.length-1;
//        for(int i=k-1;i>=0;i--)
//        {
//            lsum-=cardPoints[i];
//            rsum+=cardPoints[lind];
//            lind--;
//            maxi = Math.max(maxi,lsum+rsum);
//        }
//        return maxi;
//    }
//    public static int lengthOfLongestSubstring(String s)
//    {
//        Set<Character> st = new HashSet<>();
//        int i=0;
//        int j=i+1;
//        int maxi = 0;
//        st.add(s.charAt(i));
//        while(j<s.length())
//        {
//            if(st.contains(s.charAt(j)))
//            {
//                while(st.contains(s.charAt(j))&& i<j)
//                {
//                    st.remove(s.charAt(i));
//                    i++;
//                }
//                st.add(s.charAt(j));
//                maxi = Math.max(maxi,j-i+1);
//            }
//            else{
//                st.add(s.charAt(j));
//                maxi = Math.max(maxi,j-i+1);
//                j++;
//            }
//        }
//        return maxi;
//
//    }
//    public static int isPrefixOfWord(String sentence, String searchWord)
//    {
//        String arr[] = sentence.split(" ");
//        for(int i=0;i<arr.length;i++)
//        {
//            char ans[] = arr[i].toCharArray();
//            if(ans[0] == searchWord.charAt(0))
//            {
//                String str = arr[i].substring(0,searchWord.length());
//                if(str.equals(searchWord))
//                {
//                    return i+1;
//                }
//            }
//        }
//        return -1;
//    }
//public static int longestOnes(int[] nums, int k)
//{
//    int res = 0;
//    int i = 0;
//    int j = 0;
//    int zcount = 0;
//    while(j<nums.length)
//    {
//        if(nums[j]==1)
//        {
//            j++;
//        }
//        else{
//            zcount++;
//            if(zcount<=k)
//            {
//                j++;
//            }
//            else{
//                while(zcount>k) {
//                    if (nums[i] == 0) zcount--;
//                    i++;
//                }
//                j++;
//            }
//        }
//        res = Math.max(res,j-i);
//    }
//    return res;
//}
//public static int numSubarraysWithSum(int[] nums, int goal)
//{
//    int i=0;
//    int j=1;
//    int sum = 0;
//    int result = 0;
//    sum = nums[i];
//    while(j<nums.length)
//    {
//        if(sum>goal)
//        {
//            sum-=nums[i];
//            i++;
//        }
//        sum+=nums[j];
//        if(sum==goal)
//        {
//            result++;
//        }
//
//            j++;
//    }
//    while(i<nums.length)
//    {
//        sum-=nums[i];
//        if(sum==goal)
//        {
//            result++;
//        }
//        i++;
//    }
//    return result;
}
