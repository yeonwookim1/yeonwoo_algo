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

int n, m; //14502
int arr[9][9];
int wmap[9][9];
int mmax = 0;
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,1,0,-1 };
struct point {
	int x;
	int y;
};
void virus() {
	int vmap[9][9];
	queue<point> q;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			vmap[i][j] = wmap[i][j];
			if (vmap[i][j] == 2) {
				q.push({i,j });
			}
		}
	}
	while (!q.empty()) {
		int x = q.front().x;
		int y = q.front().y;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < 0 || yy < 0 || xx >= n || yy >= m) {
				continue;
			}
			else {
				if (vmap[xx][yy] == 0) {
					vmap[xx][yy] = 2;
					q.push({ xx,yy });
				}
			}
		}
	}
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (vmap[i][j] == 0) {
				cnt++;
			}
		}
	}
	if (mmax < cnt) {
		mmax = cnt;
	}
}
void wall(int x) {
	if (x == 3) {
		virus();
		return;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (wmap[i][j] == 0) {
				wmap[i][j] = 1;
				wall(x + 1);
				wmap[i][j] = 0;
			}
		}
	}
}
int main() {
	cin >> n >> m;
	if (n < 3 || m < 3 || n>8 || m>8) {
		return 0;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 0) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						wmap[i][j] = arr[i][j];
					}
				}
				wmap[i][j] = 1;
				wall(1);
				wmap[i][j] = 0;

			}
		}
	}
	cout << mmax;
	return 0;
}