import java.util.*;
//https://practice.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1
class Geeks {
    public long count(int n) {
        //long[] dp = new long[(int)n+1];
        //Arrays.fill(dp, 0);
        //dp[0] = 1;
        int[] score = new int[3];
        score[0] = 3;score[1]=5;score[2]=10;
        // Add your code here.
        return function(score,0,n,new HashMap<String,Integer>());
        //return dp[n];
    }
    private int function(int[] scores,int currentIndex,int targetScore,HashMap<String,Integer> memo){
        
        if(targetScore == 0)
            return 1;
            
        if(currentIndex >= scores.length)
            return 0;
            
        int currentScore  = scores[currentIndex];
        
        int consider = 0;
        
        String key = currentIndex + "-" + targetScore;
        
        if(memo.containsKey(key))
            return memo.get(key);
        
        if(currentScore <= targetScore)
            consider =  function(scores,currentIndex,targetScore - currentScore,memo);
        
        int notConsider = function(scores,currentIndex+1,targetScore,memo);
        
        
        memo.put(key,consider + notConsider);
        
        return consider + notConsider;
        
    }
}