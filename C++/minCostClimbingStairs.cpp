#include <bits/stdc++.h>
using namespace std;

int minCost(int currentStair, vector<int> cost, map<int, int> &memo)
{
    if (currentStair == cost.size())
        return 0;
    if (currentStair > cost.size())
        return 1001;

    int currentKey = currentStair;

    if (memo.find(currentKey) != memo.end())
        return memo[currentKey];

    int currentCost = cost[currentStair];

    int oneJump = currentCost + minCost(currentStair + 1, cost, memo);
    int twoJump = currentCost + minCost(currentStair + 2, cost, memo);

    memo[currentKey] = min(oneJump, twoJump);

    return min(oneJump, twoJump);
}
int minCostClimb(vector<int> cost)
{
    map<int, int> memo;
    int startFromZero = minCost(0, cost, memo);
    int startFromOne = minCost(1, cost, memo);

    return min(startFromZero, startFromOne);
}
int main()
{
    int n;
    cin >> n;
    vector<int> cost(n);

    for (int i = 0; i < n; i++)
    {
        cin >> cost[i];
    }
    //tc --> o(n)
    //sc --> o(n)
    cout << minCostClimb(cost) << endl;
    return 0;
}