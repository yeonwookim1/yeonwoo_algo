#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <string.h>
#include <vector>
#include <algorithm>
#include <tuple>
#include <math.h>
#include <stack>
#include <queue>
using namespace std;

long long int dp[1000001] = { 0, };
int go(int x) {
	if (x == 1) {
		dp[1] = 0;
		return 0;
	}
	if (dp[x] != 0) {
		return dp[x];
	}
	dp[x] = go(x - 1) + 1;

	if (x % 2 == 0) {
		int temp = dp[x / 2] + 1;
		if (dp[x] > temp) {
			dp[x] = temp;
		}
	}
	if (x % 3 == 0) {
		int temp = dp[x / 3] + 1;
		if (dp[x] > temp) {
			dp[x] = temp;
		}
	}
	return dp[x];

}
int main() {
	int x;
	cin >> x;
	cout << go(x);
	return 0;
}