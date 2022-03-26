import java.util.*;
class Solution62 {
    public int uniquePaths(int m, int n) {
        //TC recursion--> O(2^(M+N))
        //SC recursion ---> O(MAX(M,N))
        return totalWays(0,0,m,n,new HashMap<String,Integer>());
    }
    private int totalWays(int currentRow,int currentColumn,int m,int n,HashMap<String,Integer> memo){
        
        if(currentRow== m-1 && currentColumn ==n-1)
            return 1;
        if(currentRow >=m || currentColumn >=n)
            return 0;
        
        String key = currentRow+"-"+currentColumn;
        if(memo.containsKey(key))
            return memo.get(key);
        
        int rightMove = totalWays(currentRow,currentColumn+1,m,n,memo);
        int  downMove = totalWays(currentRow+1,currentColumn,m,n,memo);
        
        
        memo.put(key,rightMove+downMove);
        return rightMove + downMove;
        
    }
}