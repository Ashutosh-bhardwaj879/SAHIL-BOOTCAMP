#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    int numRollsToTarget(int d, int f, int target)
    {
        // we should use +1 always otherwise overflow error comes
        vector<vector<int>> vec(d + 1, vector<int>(target + 1, -1));
        unordered_map<string, int> map;
        return totalWays(d, f, target, vec);
    }
    int totalWays(int n, int f, int targetSum, vector<vector<int>> &vec)
    {
        // we used all dices and got targetSum
        if (n == 0 && targetSum == 0)
            return 1;

        // we used all dices but still could not get targetSum
        if (n == 0 && targetSum != 0)
            return 0;

        // we have to use all dices to obtain targetSum
        // here we didnt use all dices and got targetSum or lesser than that
        if (n != 0 && targetSum <= 0)
            return 0;

        int MOD = 1000000007;

        int ways = 0;

        if (vec[n][targetSum] != -1)
            return vec[n][targetSum];

        // we called all the branches of the faces of a single dice
        for (int i = 1; i <= f; i++)
        {
            // reduced dice count and targetSum
            int tempAns = totalWays(n - 1, f, targetSum - i, vec) % MOD;
            ways = ways % MOD;
            ways = (ways + tempAns) % MOD;
        }

        vec[n][targetSum] = ways;

        return ways;
    }
};
/*class Solution
{
public:
    int numRollsToTarget(int d, int f, int target)
    {
        unordered_map<string, int> map;
        return totalWays(d, f, target, map);
    }
    int totalWays(int n, int f, int targetSum, unordered_map<string, int> &memo)
    {
        // we used all dices and got targetSum
        if (n == 0 && targetSum == 0)
            return 1;

        // we used all dices but still could not get targetSum
        if (n == 0 && targetSum != 0)
            return 0;

        // we have to use all dices to obtain targetSum
        // here we didnt use all dices and got targetSum or lesser than that
        if (n != 0 && targetSum <= 0)
            return 0;

        int MOD = 1000000007;

        int ways = 0;

        string key = to_string(n) + "-" + to_string(targetSum);

        if (memo.find(key) != memo.end())
            return memo[key];

        // we called all the branches of the faces of a single dice
        for (int i = 1; i <= f; i++)
        {
            // reduced dice count and targetSum
            int tempAns = totalWays(n - 1, f, targetSum - i, memo) % MOD;
            ways = ways % MOD;
            ways = (ways + tempAns) % MOD;
        }

        memo[key] = ways;

        return ways;
    }
};*/