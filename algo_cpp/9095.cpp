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

int dp[1001] = { 0, }; //9095 top-down
int main() {
	int t;
	cin >> t;
	dp[1] = 1;
	dp[2] = 2;
	dp[3] = 4;
	while (t) {
		int n;
		cin >> n;

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		cout << dp[n] << "\n";
		t--;
	}



	return 0;
}

//int dp[101] = { 0, }; //9095 Bottom-up
//int go(int n) {
//	
//	if (n <= 3) {
//		return dp[n];
//	}
//	if (dp[n] != 0) {
//		return dp[n];
//	}
//	else {
//
//		return dp[n] = go(n - 1) + go(n - 2) + go(n - 3);
//	}
//}
//int main() {
//	int t;
//	cin >> t;
//	dp[1] = 1;
//	dp[2] = 2;
//	dp[3] = 4;
//	while (t) {
//		int n;
//		cin >> n;
//		cout << go(n)<<"\n";
//		t--;
//	}
//
//
//
//	return 0;
//}