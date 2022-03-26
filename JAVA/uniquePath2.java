import java.util.*;
class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return totalWays(0,0,m,n,new HashMap<String,Integer>(),obstacleGrid);
    }
    private int totalWays(int currentRow,int currentColumn,int m,int n,HashMap<String,Integer> memo,int[][] obstacleGrid){
        
        
         if(currentRow >=m || currentColumn >=n || obstacleGrid[currentRow][currentColumn] == 1)
            return 0;
        
        if(currentRow== m-1 && currentColumn ==n-1)
            return 1;
       
        String key = currentRow+"-"+currentColumn;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int rightMove = totalWays(currentRow,currentColumn+1,m,n,memo,obstacleGrid);
        int  downMove = totalWays(currentRow+1,currentColumn,m,n,memo,obstacleGrid);
        
        
        memo.put(key,rightMove+downMove);
        return rightMove + downMove;
        //TC --> O(M*N)
        //SC --> O(M*N)
    }
}
