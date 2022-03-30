import java.util.*;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestSubsequence(text1,text2,0,0,text1.length(),text2.length(),new HashMap<>());
    }
    private int longestSubsequence(String s1,String s2,int start1,int start2,int end1,int end2,HashMap<String,Integer> memo){
        if(start1 >= end1 || start2 >= end2) return 0;
        
        int ans=0;
        String currentkey = start1+"-"+start2;
        if(memo.containsKey(currentkey))
            return memo.get(currentkey);
        
        if(s1.charAt(start1) == s2.charAt(start2)){
            ans =1 +longestSubsequence(s1,s2,start1+1,start2+1,end1,end2,memo); 
        }
        
        else{
            int a=longestSubsequence(s1,s2,start1,start2+1,end1,end2,memo);
            int b=longestSubsequence(s1,s2,start1+1,start2,end1,end2,memo);
            ans=Math.max(a,b);
        }
        memo.put(currentkey,ans);
        return ans;
        //REC
        //TC -- O(2^MIN(M,N))
        //SC -- O(MIN(M,N))
        
        //DP
        //TC -- O(M*N)
        //SC -- O(M*N)
    }
}