import java.util.*;

class numberValidParenthisis {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        if (n % 2 == 0)
            System.out.println(findNthCatalan(n / 2, memo));
        else
            System.out.println("n should be even");
        scn.close();
    }

    public static int findNthCatalan(int n, HashMap<Integer, Integer> memo) {
        if (n == 1 || n == 0)
            return 1;

        int ways = 0;

        int key = n;

        if (memo.containsKey(key))
            return memo.get(key);

        for (int i = 0; i < n; i++) {
            int a = findNthCatalan(i, memo);
            int b = findNthCatalan(n - i - 1, memo);
            int c = a * b;
            ways += c;
        }

        memo.put(key, ways);
        return ways;
    }
}
