package codechefsums;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String source = sc.next();
            String target = sc.next();

            int lenSource = source.length();
            int lenTarget = target.length();

            int idxSource = 0;
            int idxTarget = 0;

            while (idxSource < lenSource && idxTarget < lenTarget) {
                if (source.charAt(idxSource) == target.charAt(idxTarget)) {
                    idxTarget++;
                }
                idxSource++;
            }

            if (idxTarget != lenTarget) {
                System.out.println(-1);
                continue;
            }

            long totalCost = 0;
            int currentIdx = lenSource;

            for (int i = lenTarget - 1; i >= 0; i--) {
                while (currentIdx >= 1 && source.charAt(currentIdx - 1) != target.charAt(i)) {
                    currentIdx--;
                }
                totalCost += currentIdx;
                currentIdx--;
            }

            long baseCost = (long) lenTarget * lenSource + lenSource - lenTarget - ((long) lenTarget * (lenTarget - 1)) / 2;

            System.out.println(baseCost - totalCost);
        }

        sc.close();
    }
}
