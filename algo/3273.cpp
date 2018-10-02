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

int n, x; //3273
vector<int> arr;
int find(int x) {
	int mid = 0;
	int s = 0;
	int e = n;
	while (s < e) {
		mid = (s + e) / 2;
		if (x > arr[mid]) {
			s = mid + 1;
		}
		else if (x < arr[mid]) {
			e = mid - 1;
		}
		else {
			return 1;
		}
	}

	if (arr[s] == x) {
		return 1;
	}

	return 0;
}
int main() {

	int sum = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int temp;
		cin >> temp;
		arr.push_back(temp);
	}
	cin >> x;
	sort(arr.begin(), arr.end());
	for (int i = 0; i < n; i++) {
		sum += find(x - arr[i]);
	}
	cout << sum / 2;
	return 0;
}