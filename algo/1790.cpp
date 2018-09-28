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
using namespace std;

int llen(int n) { //1790
	int len = 0;
	while (n) {
		len++;
		n /= 10;
	}
	return len;
}
int main() {

	long long int k;
	long long int n;
	cin >> n >> k;
	int len = 0;
	int t = 0;
	for (int i = 1; i <= n; i++) {
		len += llen(i);
		if (len >= k) {
			t = i;
			break;
		}
	}
	while (len > k) {
		t /= 10;
		len--;
	}
	if (len == k) {
		cout << t % 10 << endl;
	}
	else {
		cout << "-1" << endl;
	}
	return 0;
}