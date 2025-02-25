package crytographylab;
import java.util.*;
class plaintocipher {
    public static void main(String[] args) {
//        String str = "CCE IS EXCELLENT";
        StringBuilder res = new StringBuilder("CCE IS EXCELLENT");
        int k = 2;
        for(int i=0;i<res.length();i++)
        {
            char ch = res.charAt(i);
            if(ch!=' ') res.setCharAt(i,(char)(ch+k));
        }
        System.out.println(res);
    }
}