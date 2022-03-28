import java.util.*;

//https://leetcode.com/problems/maximal-square/
class Solution221 {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int side_length = 0;
        int ans = 0;
        HashMap<String, Integer> memo = new HashMap<>();

        for (int currentRow = 0; currentRow < m; currentRow++) {
            for (int currentCol = 0; currentCol < n; currentCol++) {
                if (matrix[currentRow][currentCol] == '1') {
                    side_length = maximumSize(matrix, currentRow, currentCol, m, n, memo);
                    ans = Math.max(ans, side_length * side_length);
                }
            }
        }

        return ans;
    }

    private int maximumSize(char[][] matrix, int currentRow, int currentCol, int m, int n,
            HashMap<String, Integer> memo) {

        if (currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n
                || matrix[currentRow][currentCol] == '0')
            return 0;

        String key = currentRow + "-" + currentCol;

        if (memo.containsKey(key))
            return memo.get(key);

        int rightExpansion = 1 + maximumSize(matrix, currentRow, currentCol + 1, m, n, memo);

        int downExpansion = 1 + maximumSize(matrix, currentRow + 1, currentCol, m, n, memo);

        int rightDiagExpansion = 1 + maximumSize(matrix, currentRow + 1, currentCol + 1, m, n, memo);

        memo.put(key, Math.min(rightExpansion, Math.min(downExpansion, rightDiagExpansion)));

        return memo.get(key);

    }
    // RECURSION
    // TC --> o(m*n*3^mn)
    // SC --> o(m)
    // DP
    // TC --> o(m^2n^2) or o(m^2 n) o(mN)
    // SC --> o(m*n)
}