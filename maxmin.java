import java.util.*;
public class maxmin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int elements = s.nextInt();
        int arr[] = new int[elements];
        for(int i=0;i<elements;i++)
        {
            arr[i] = s.nextInt();
        }
        Map<Integer,Integer> frequency = new HashMap<>();
        Set<Integer> st = new HashSet<>();
        for(int i:arr)
        {
            frequency.put(i,frequency.getOrDefault(i,0)+1);
            st.add(i);
        }
        for(int i:st)
        {
            System.out.println("The Element in the Array is:"+i+"-"+frequency.get(i));
        }
    }
}
