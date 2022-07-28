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
#include <sstream>
#include <time.h>
using namespace std;

int arr[1001]; //1965
int dp[1001];
int n;
int lis(int x) {
	if (dp[x] != 0) {
		return dp[x];
	}
	else {
		dp[x] = 1;
		for (int i = x + 1; i < n; i++) {
			if (arr[x] < arr[i]) {
				int check = lis(i) + 1;
				if (dp[x] < check) {
					dp[x] = check;
				}
			}
		}
	}

	return dp[x];
}
int main() {
	int ans = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	for (int i = 0; i < n; i++) {
		if (dp[i] == 0) {
			int check = lis(i);
			if (ans < check) {
				ans = check;
			}
		}
	}
	cout << ans;
	return 0;
}