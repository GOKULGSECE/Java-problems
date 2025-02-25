import java.util.*;

class Solution {
    public static void recuri(String titles, StringBuilder p, Set<String> st, Set<String> result) {
        if (p.length() > 0) {
            result.add(p.toString());
        }

        for (int i = 0; i < titles.length(); i++) {
            if (st.contains(i + "")) continue;

            p.append(titles.charAt(i));
            st.add(i + "");

            recuri(titles, p, st, result);

            p.deleteCharAt(p.length() - 1);
            st.remove(i + "");
        }
    }

    public static int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        recuri(tiles, new StringBuilder(), new HashSet<>(), result);
        return result.size();
    }

    public static void main(String[] args) {
        String str = "AAB";
        System.out.println(numTilePossibilities(str)); // Output: 8
    }
}
