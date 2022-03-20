//https://leetcode.com/problems/climbing-stairs/
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        System.out.println(solution(0, 4, map));
        scn.close();
    }

    public static int solution(int currentStair, int targetStair, HashMap<Integer, Integer> memo) {
        if (currentStair == targetStair)
            return 1;
        if (currentStair > targetStair)
            return 0;

        int currentKey = currentStair;

        if (memo.containsKey(currentKey)) {
            return memo.get(currentKey);
        }

        int oneJump = solution(currentStair + 1, targetStair, memo);
        int twoJump = solution(currentStair + 2, targetStair, memo);

        memo.put(currentKey, oneJump + twoJump);

        return oneJump + twoJump;
    }
}