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

int main() { //3052
	int ans = 0;
	int check[1001] = { 0, };
	for (int i = 0; i < 10; i++) {
		int a;
		cin >> a;
		check[a % 42]++;
	}
	for (int i = 0; i < 1000; i++) {
		if (check[i] != 0) {
			ans++;
		}
	}
	cout << ans;
	return 0;
}