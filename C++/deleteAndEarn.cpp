#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int n = nums.size();
        
        int maxElement = *max_element(nums.begin(), nums.end());
        //int maxElement = nums[nums.size()-1];
        vector<int> freq(maxElement+1);
        for(auto &it : nums)
            freq[it]++;
        map<int,int> memo;
        return maxPoints(0,freq,memo);
    }
private:
    int maxPoints(int currentIndex,vector<int> &freq,map<int,int> &memo)
    {
        if(currentIndex >= freq.size())
            return 0;
        
        int currentKey = currentIndex;
        
        if(memo.find(currentKey)!=memo.end())
            return memo[currentKey];
        
        int Delete = currentIndex*freq[currentIndex] + maxPoints(currentIndex+2,freq,memo);
        
        int noDelete = maxPoints(currentIndex+1,freq,memo);
        
        memo[currentKey] =  max(Delete,noDelete);
        return max(Delete,noDelete);
        
    }
};