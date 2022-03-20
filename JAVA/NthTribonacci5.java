//https://leetcode.com/problems/n-th-tribonacci-number/
import java.util.*;
class Solution1 {
    public int tribonacci(int n) 
    {
       return NthTribonacci(n,new HashMap<Integer,Integer>());
    }
    
    private int NthTribonacci(int n,HashMap<Integer,Integer> map)
    {   
        
        if(n==0 || n==1)
            return n;
        if(n==2)
            return n-1;
        
        int currentKey = n;
        
        if(map.containsKey(currentKey)){
            return map.get(currentKey);
        }
        
        int callOne   = NthTribonacci(n-1,map);
        int callTwo   = NthTribonacci(n-2,map);
        int callThree = NthTribonacci(n-3,map);
        
        map.put(currentKey,callOne+callTwo+callThree);
        
        return callOne+callTwo+callThree;
    }
}
class Tribonacci{
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int n = 25;
        System.out.println(sol.tribonacci(n));
    }
}