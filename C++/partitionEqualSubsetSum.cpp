#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    bool canPartition(vector<int> &nums)
    {
        int sum = 0;
        for (int num : nums)
        {
            sum += num;
        }
        if (sum % 2 != 0)
        {
            return false;
        }
        map<string, bool> map;
        return isPossible(0, sum / 2, nums, map);
    }

private:
    bool isPossible(int currentIndex, int targetSum, vector<int> &nums, map<string, bool> &memo)
    {
        if (targetSum == 0)
            return true;

        if (currentIndex >= nums.size())
            return false;

        string currentKey = to_string(currentIndex) + "-" + to_string(targetSum);

        if (memo.find(currentKey) != memo.end())
            return memo[currentKey];

        int currentSum = nums[currentIndex];

        bool consider = false;

        if (currentSum <= targetSum)
        {
            consider = isPossible(currentIndex + 1, targetSum - currentSum, nums, memo);

            if (consider == true)
            {
                memo[currentKey] = true;
                return true;
            }
        }

        bool notConsider = isPossible(currentIndex + 1, targetSum, nums, memo);

        memo[currentKey] = consider || notConsider;

        return memo[currentKey];
    }
};

int main()
{
    Solution  sol;
    vector<int> nums = {1,5,11,5};
    cout  << sol.canPartition(nums);
    
}