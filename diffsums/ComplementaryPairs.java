package diffsums;
import java.util.*;
public class ComplementaryPairs {
    public static int countComplementaryPairs(String[] words) {
        Map<Integer, Integer> maskCount = new HashMap<>();
        int count = 0;
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask ^= (1 << (c - 'a'));
            }
            for (int i = 0; i < 26; i++) {
                int modifiedMask = mask ^ (1 << i);
                count += maskCount.getOrDefault(modifiedMask, 0);
            }
            maskCount.put(mask, maskCount.getOrDefault(mask, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        String[] StringData = {"abc", "abcd", "bc", "adc"};
        System.out.println(countComplementaryPairs(StringData));
    }
}
