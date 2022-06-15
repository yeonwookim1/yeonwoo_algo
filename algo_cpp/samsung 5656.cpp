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

int arr[15][12]; //5656 º®µ¹±ú±â
int n, w, h;
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,1,0,-1 };
int block = 0;
int ans = 99999;
struct point {
	int p;
	int x;
	int y;
};
bool check_range(int x, int y)
{
	if (x >= 0 && y >= 0 && x < h && y < w)
		return true;
	else
		return false;

}
void down() {
	for (int j = 0; j < w; j++) {

		for (int i = h - 1; i >= 0; i--) {
			if (arr[i][j] == 0) {
				for (int k = i; k >= 0; k--) {
					if (arr[k][j] != 0) {
						int tl;
						tl = arr[k][j];
						arr[k][j] = arr[i][j];
						arr[i][j] = tl;
						break;
					}
				}
			}
		}
	}
	
}
void breakwall(int a, int x, int y) {
	
	queue<point> q;
	q.push({ a,x,y });
	while (!q.empty()) {
		int a = q.front().p;
		int x = q.front().x;
		int y = q.front().y;
		arr[x][y] = 0;
		q.pop();
		for (int i = 1; i < a; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				int nx = x + dx[j] * i;
				int ny = y + dy[j] * i;
				int nd = arr[nx][ny];
				if (nx<0 || ny<0 || nx>=h || ny>=w) {
					continue;
				}
				else {
					if (arr[nx][ny] != 0)
					{
						q.push({ nd,nx,ny });
						arr[nx][ny] = 0;
					}
				}
					
			}
		}


	}
	
}
void go(int count) {


	if (count == n) {
		int cnt = 0;
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				if (arr[i][j] != 0)
					cnt++;

		if (cnt < ans)
			ans = cnt;

		return;
	}
	else {
		int tempt[15][12];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				tempt[i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < w; i++) {
			int x = 0;
			int y = i;
			for (int j = 0; j < h; j++) {
				if (arr[j][i] != 0) {
					x = j;
					break;
				}
			}
			breakwall(tempt[x][y], x, y);
			down();
			go(count + 1);
			for (int ii = 0; ii < h; ii++) {
				for (int jj = 0; jj < w; jj++) {
					arr[ii][jj] = tempt[ii][jj];
				}
			}

		}

	}
}



int main() {
	int T;
	cin >> T;
	for (int test = 1; test <= T; test++) {
		ans = 987654321;
		cin >> n >> w >> h;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				cin >> arr[i][j];
			}
		}
		go(0);
		cout <<"#"<<test<<" "<< ans<<"\n";


	}
	

	return 0;
}