//https://leetcode.com/problems/house-robber-ii/submissions/
#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int rob(vector<int> &nums)
    {
        int n = nums.size();
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return max(nums[0], nums[1]);
        if (n == 3)
            return max(max(nums[0], nums[1]), nums[2]);
        // since we are in a circle we cant rob 1st and last house continously
        // we can only rob either 1st house to second last house [0,n-2];
        // or we can rob from second house to last hosue --> [1,n-1]
        map<int, int> map1;
        map<int, int> map2;
        // we have to use two maps becuase the overlapping sub[roblem thing wont happedn her
        // always eg map1 will go from 0->n-2
        // and map2 will go from 1 -> n-1
        // so since map1 caanot hold all values of map2 we wont use a single map

        int startWithFirstHouse = maxMoney(0, n - 2, nums, map1);
        int startWithSecondHouse = maxMoney(1, n - 1, nums, map2);

        return max(startWithFirstHouse, startWithSecondHouse);
    }

private:
    int maxMoney(int currentHouse, int targetHouse, vector<int> &nums, map<int, int> &memo)
    {
        // do check this thing ..here = condition is not there
        // becuase at last house robber we have n as target house which is out of the array
        // while in this we are taking n inside the array so at =  if we return
        // we will get wrong answer
        if (currentHouse > targetHouse)
            return 0;

        int currentKey = currentHouse;

        if (memo.find(currentKey) != memo.end())
            return memo[currentKey];

        int HouseRobbed = nums[currentHouse] + maxMoney(currentHouse + 2, targetHouse, nums, memo);
        int NoHouseRobbed = maxMoney(currentHouse + 1, targetHouse, nums, memo);

        memo[currentKey] = max(HouseRobbed, NoHouseRobbed);

        return max(HouseRobbed, NoHouseRobbed);
    }
};
int main()
{
    Solution sol;
    vector<int> nums = {1,2,3,1};
    cout << sol.rob(nums);
}