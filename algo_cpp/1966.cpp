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

struct point {//1966
	int a;
	int b;
};

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int testcase;
	cin >> testcase;
	for (int i = 0; i < testcase; i++) {
		queue<point> q;
		int m, n;
		cin >> n >> m;
		for (int i = 0; i < n; i++) {
			int temp;
			cin >> temp;
			q.push({ temp,i });
		}
		for (int kk = 0; kk < 100; kk++) {

			int x = q.size();
			int max = 0;
			while (x--) {
				int xx = q.front().a;
				int yy = q.front().b;
				if (max < xx) {
					max = xx;
				}
				q.pop();
				q.push({ xx,yy });
			}
			while (1) {
				int xx = q.front().a;
				int yy = q.front().b;
				if (xx == max) {
					break;
				}
				q.pop();
				q.push({ xx,yy });
			}

			if (m == q.front().b) {
				cout << kk + 1 << "\n";
				break;
			}
			else {
				q.pop();
			}

		}

		while (!q.empty()) {
			q.pop();
		}

	}

	return 0;
}