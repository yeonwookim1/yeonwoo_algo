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

struct point { //11758
	int x;
	int y;
};
int ccw(point a, point b, point c) {
	return (b.x - a.x)*(c.y - a.y) - (c.x - a.x)*(b.y - a.y);
}
int main() {
	point arr[3];
	for (int i = 0; i < 3; i++) {
		cin >> arr[i].x >> arr[i].y;
	}
	int ans = ccw(arr[0], arr[1], arr[2]);
	if (ans < 0) {
		cout << "-1";
	}
	else if (ans == 0) {
		cout << "0";
	}
	else {
		cout << "1";
	}


	return 0;
}