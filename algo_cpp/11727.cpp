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

int dp[1001] = { 0, }; //11727
int main() {

	int n;
	cin >> n;
	dp[0] = 1;
	dp[1] = 1;

	for (int i = 2; i <= n; i++) {
		dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
	}
	cout << dp[n];

	return 0;
}

//int dp[1001] = { 0, }; //11727 Top-down Ãß°¡
//int go(int n) {
//	if (n == 1) {
//		dp[1] = 1;
//		return 1;
//	}
//	if (n == 2) {
//		dp[2] = 3;
//		return 3;
//	}
//	if (dp[n] != 0) {
//		return dp[n];
//	}
//	else {
//		return dp[n] = (go(n - 1) + 2 * go(n - 2)) % 10007;
//	}
//}
//int main() {
//
//	int n;
//	cin >> n;
//	cout << go(n);
//
//	return 0;
//}