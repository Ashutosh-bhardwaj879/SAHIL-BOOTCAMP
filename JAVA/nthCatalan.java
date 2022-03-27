import java.math.BigInteger;
import java.util.*;
class SolutionGFG
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        return nthCatalan(n,new HashMap<Integer,BigInteger>());
    }
    private static BigInteger nthCatalan(int n,HashMap<Integer,BigInteger> memo)
    {
        if(n==0 || n==1)
            return BigInteger.valueOf(1);
            
        BigInteger ways = BigInteger.valueOf(0);
        
        int currentKey =  n;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        for(int i=0;i<=n-1;i++){
            BigInteger a = nthCatalan(i,memo);
            BigInteger b = nthCatalan(n-i-1,memo);
            BigInteger c = a.multiply(b);
            ways = ways.add(c);
        }
        
        memo.put(currentKey,ways);
        
        return ways;
    }
}