package minimumeditdistance;

public class minimumeditdistance {
    public static int recurcount(String str1,String str2,int m,int n)
    {
        if(m==0)
        {
            return n;
        }
        if(n==0){
            return m;
        }
        if(str1.charAt(m-1)==str2.charAt(n-1)){
            return recurcount(str1,str2,m-1,n-1);
        }
        return 1+Math.min(recurcount(str1,str2,m,n-1),Math.min(recurcount(str1,str2,m-1,n),recurcount(str1,str2,m-1,n-1)));
    }
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "bcbd";
        System.out.println(recurcount(str1,str2,str1.length(),str2.length()));
    }
}
// if insert operation then m,n-1;
// if delete operation then m-1,n;
// if replace operation then m-1,n-1;
