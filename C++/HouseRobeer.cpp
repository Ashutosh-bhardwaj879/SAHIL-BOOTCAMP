#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int rob(vector<int> &nums)
    {
        map<int, int> memo;
        int maxMoney = robMaxHouse(0, nums, memo);
        return maxMoney;
    }

private:
    int robMaxHouse(int currentHouse, vector<int> nums, map<int, int> &memo)
    {
        if (currentHouse >= nums.size())
            return 0;

        int currentKey = currentHouse;

        if (memo.find(currentKey) != memo.end())
            return memo[currentKey];

        int currentMoney = nums[currentHouse];

        int RobbedHouse = currentMoney + robMaxHouse(currentHouse + 2, nums, memo);
        int notRobbedHouse = robMaxHouse(currentHouse + 1, nums, memo);

        memo[currentKey] = max(RobbedHouse, notRobbedHouse);

        return max(RobbedHouse, notRobbedHouse);
        // TC O(n)
        // SC O(n)
    }
};

int main()
{
    Solution sol;
    vector<int> nums = {2, 7, 9, 3, 1};
    cout << sol.rob(nums);
}