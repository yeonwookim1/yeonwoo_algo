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

using namespace std;

char arr[12][6]; //11559
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,1,0,-1 };
int visit[12][6];
int ans = 0;
int ciki = 1;
struct point {
	char a;
	int x;
	int y;
};

void bfs(char color, int x, int y) {
	queue<point> q;
	q.push({ color,x,y });
	visit[x][y] = 1;
	int cnt = 1;
	while (!q.empty()) {
		int x = q.front().x;
		int y = q.front().y;
		char a = q.front().a;

		q.pop();
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx < 0 || yy < 0 || xx >= 12 || yy >= 6) {
				continue;
			}
			else {

				if (arr[xx][yy] == a && visit[xx][yy] == 0) {
					q.push({ arr[xx][yy],xx,yy });
					visit[xx][yy] = 1;
					cnt++;
				}

			}
		}

	}
	if (cnt >= 4) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (visit[i][j] == 1) {
					arr[i][j] = '.';
					visit[i][j] = 0;
				}
			}
		}
		ciki = 1;
	}
	else {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				visit[i][j] = 0;

			}
		}
	}
}
void down() {
	int ct = 11;
	for (int i = 0; i < 6; i++) {
		for (int j = 11; j >= 0; j--) {
			if (arr[j][i] == '.') {
				for (int t = j; t >= 0; t--) {
					if (arr[t][i] != '.') {
						int temp = arr[t][i];
						arr[t][i] = arr[j][i];
						arr[j][i] = temp;
						break;
					}
				}
			}

		}
	}
	ans++;

}
int main() {
	for (int i = 0; i < 12; i++) {
		for (int j = 0; j < 6; j++) {
			cin >> arr[i][j];
		}
	}

	while (ciki) {
		ciki = 0;
		for (int i = 11; i >= 0; i--) {
			for (int j = 0; j <6; j++) {
				if (arr[i][j] != '.') {
					bfs(arr[i][j], i, j);


					/*for (int i = 0; i < 12; i++) {
					for (int j = 0; j < 6; j++) {
					cout << arr[i][j];
					}
					cout << endl;
					}*/

				}

			}
		}
		down();
	}

	cout << ans - 1;
	return 0;
}