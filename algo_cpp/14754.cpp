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

long long int arr[1001][1001]; //14754
long long int check[1001][1001];

int main() {

	long long int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
		}
	}
	for (int i = 0; i < n; i++) {
		int x, y;
		int max = 0;
		for (int j = 0; j < m; j++) {

			if (arr[i][j] > max) {
				max = arr[i][j];
				x = i;
				y = j;
			}
		}
		check[x][y]++;
	}

	for (int i = 0; i < m; i++) {
		int x, y;
		int max = 0;
		for (int j = 0; j < n; j++) {

			if (max < arr[j][i]) {
				max = arr[j][i];
				x = j;
				y = i;
			}
		}
		check[x][y]++;
	}

	int sum = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (check[i][j] == 0) {
				sum += arr[i][j];
			}
		}
	}
	cout << sum;
	return 0;
}