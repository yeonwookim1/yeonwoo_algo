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

int main() { //2501
	int n, k;
	vector<int> arr;
	int cnt = 0;
	cin >> n >> k;
	for (int i = 1; i <= n; i++) {
		if (n%i == 0) {
			arr.push_back(i);
			cnt++;
		}
	}
	if (cnt >= k) {

		cout << arr[k - 1];
	}
	else {
		cout << "0";
	}
	return 0;
}