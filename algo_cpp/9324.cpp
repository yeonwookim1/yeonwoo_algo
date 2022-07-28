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

int main() { //9324
	int check[30] = { 0, };
	int n;
	cin >> n;
	while (n) {
		int test = -1;
		string s;
		cin >> s;
		for (int i = 0; i < s.size(); i++) {
			check[s[i] - 65] ++;
			if (check[s[i] - 65] == 3) {
				if (s[i] == s[i + 1]) {
					check[s[i] - 65] = 0;
					i++;
				}
				else {
					cout << "FAKE\n";
					test *= -1;
					break;
				}
			}
		}
		if (test == -1) {
			cout << "OK\n";
		}

		for (int i = 0; i < 30; i++) {
			check[i] = 0;
		}
		n--;
	}
	return 0;
}