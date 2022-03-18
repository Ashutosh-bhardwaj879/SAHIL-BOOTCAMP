#include <bits/stdc++.h>
using namespace std;

int totalWays(int currentStair, int targetStair, map<int, int> &memo)
{
    if (currentStair == targetStair)
        return 1;
    if (currentStair > targetStair)
        return 0;

    int currentKey = currentStair;

    if (memo.find(currentKey) != memo.end())
    {
        return memo.at(currentKey);
    }
    int oneJump = totalWays(currentStair + 1, targetStair, memo);
    int twoJumps = totalWays(currentStair + 2, targetStair, memo);

    memo[currentKey] = oneJump + twoJumps;

    return oneJump + twoJumps;
}
int climbStairs(int n)
{
    map<int, int> m;
    return totalWays(0, n, m);
}
int main()
{
    int n;
    cin >> n;
    cout << climbStairs(n) << endl;
}