package slidingwindow;

import java.util.*;

public class longestsubstringwithkunique {
    public static int longestsubstring(String str,int k)
    {
        int j=0;
        int count = 0;
        int result = 0;
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            mp.put(str.charAt(i),mp.getOrDefault(str.charAt(i),0)+1);
            count++;
            while(mp.size()>k) {
                mp.put(str.charAt(j), mp.get(str.charAt(j)) - 1);
                count--;
                if (mp.get(str.charAt(j)) == 0) {
                    mp.remove(str.charAt(j));
                }
                j++;
            }
            result = Math.max(count,result);
        }
        return count;
    }
    public static void main(String[] args) {
        String str = "aabaaab";
        int k = 2;
        System.out.println(longestsubstring(str,k));
    }
}
