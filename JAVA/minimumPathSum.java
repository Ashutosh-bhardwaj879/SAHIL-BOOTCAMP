import java.util.*;
class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return minPath(0,0,m,n,grid,new HashMap<String,Integer>());
    }
    
    private int minPath(int currentRow,int currentCol,int m,int n,int[][] grid,HashMap<String,Integer> memo){
        if(currentRow == m-1 && currentCol == n-1)
            return grid[currentRow][currentCol];
        
        if(currentRow >=m || currentCol >=n)
            return 10001;
        
        String key = currentRow+"-"+currentCol;
        
        if(memo.containsKey(key))
            return memo.get(key);
            
        int rightMove = grid[currentRow][currentCol] + minPath(currentRow,currentCol+1,m,n,grid,memo);
        int downMove = grid[currentRow][currentCol] + minPath(currentRow+1,currentCol,m,n,grid,memo);
        
        memo.put(key,Math.min(rightMove,downMove));
        return Math.min(rightMove,downMove);
    }
}