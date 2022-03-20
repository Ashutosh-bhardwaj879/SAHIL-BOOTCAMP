#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        map<string,int> memo;
        return totalWays(nums,0,target,memo);
    }
private:
    int totalWays(vector<int> &nums,int currentIndex,int target,map<string,int> &memo)
    {
        if(currentIndex == nums.size() && target == 0)
            return 1;
        
        
        if(currentIndex == nums.size() && target != 0)
            return 0;
        
        string currentKey = to_string(currentIndex) + "-" + to_string(target);
        
        if(memo.find(currentKey) != memo.end())
            return memo[currentKey];
        
        int posSign = totalWays(nums,currentIndex+1,target - nums[currentIndex],memo);
        
        int negSign = totalWays(nums,currentIndex+1,target + nums[currentIndex],memo);
        
        memo[currentKey] = posSign+negSign;
        
        return posSign + negSign;
    }
};

