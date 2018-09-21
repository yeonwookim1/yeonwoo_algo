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

long long int dp[1000001] = { 0, }; // top-down
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

//long long int dp[1000001] = { 0, };  // bottom-up
//int main() {
//
//	int x;
//	cin >> x;
//	dp[1] = 0;
//	for (int i = 2; i <= x; i++) {
//		dp[i] = dp[i - 1] + 1;
//		if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
//			dp[i] = dp[i / 2] + 1;
//		}
//		if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
//			dp[i] = dp[i / 3] + 1;
//		}
//	}
//	cout << dp[x];
//	return 0;
//}