// https://leetcode.com/problems/fibonacci-number/
#include <bits/stdc++.h>
using namespace std;

int NthFib(int n, map<int, int> &memo)
{
    if (n == 0 || n == 1)
        return n;

    int currentKey = n;

    if (memo.find(currentKey) != memo.end())
        return memo.at(currentKey);

    int callMinusOne = NthFib(n - 1, memo);
    int callMinusTwo = NthFib(n - 2, memo);

    memo[currentKey] = callMinusOne + callMinusTwo;
    return callMinusOne + callMinusTwo;
}
int fibonacci(int n)
{
    map<int, int> map;
    return NthFib(n, map);
}
int main()
{
    int n;
    cin >> n;
    cout << fibonacci(n) << endl;
}