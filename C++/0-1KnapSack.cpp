#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    // Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, int wt[], int val[], int n)
    {
        map<string, int> map;
        return maxProfit(0, W, wt, val, n, map);
    }

private:
    int maxProfit(int currentItem, int capacity, int weights[], int profit[], int n, map<string, int> &map)
    {
        if (currentItem == n)
            return 0;

        int considerd = 0;
        int currentItemProfit = profit[currentItem];
        int currentItemWeight = weights[currentItem];

        string currentKey = to_string(currentItem) + "-" + to_string(capacity);

        if (map.find(currentKey) != map.end())
            return map[currentKey];

        if (currentItemWeight <= capacity)
            considerd = currentItemProfit + maxProfit(currentItem + 1, capacity - currentItemWeight, weights, profit, n, map);

        int notConsiderd = maxProfit(currentItem + 1, capacity, weights, profit, n,map);

        map[currentKey] = max(considerd, notConsiderd);
        return max(considerd, notConsiderd);
    }
};

int main()
{
    Solution sol;
    int n = 3;
    int W = 3;
    int val[] = {1, 2, 3};
    int wt[] = {4, 5, 6};
    cout << sol.knapSack(W, wt, val, n) << endl;
}