//https://leetcode.com/problems/fibonacci-number/
import java.util.*;

public class nthfib2 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n, new HashMap<Integer, Integer>()));
    }

    public static int fib(int n, HashMap<Integer, Integer> map) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int currentKey = n;

        if (map.containsKey(currentKey)) {
            return map.get(currentKey);
        }

        int callOne = fib(n - 1, map);
        int callTwo = fib(n - 2, map);

        map.put(currentKey, callOne + callTwo);

        return callOne + callTwo;
    }
}
