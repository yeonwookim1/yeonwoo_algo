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

int arr[501][501]; //1937
int dp[501][501];
int n;
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,1,0,-1 };
int dfs(int x, int y) {
	if (dp[x][y] != 0) {
		return dp[x][y];
	}
	else {
		dp[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < 0 || yy < 0 || xx >= n || yy >= n) {
				continue;
			}
			else {
				if (arr[x][y] < arr[xx][yy]) {
					int check = dfs(xx, yy) + 1;
					if (check > dp[x][y]) {
						dp[x][y] = check;
					}

				}
			}
		}


	}

	return dp[x][y];
}
int main() {
	int ans = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (dp[i][j] == 0) {
				int check = dfs(i, j);
				if (ans < check) {
					ans = check;
				}
			}
		}
	}
	cout << ans;

	return 0;
}