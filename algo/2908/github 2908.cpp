#include <iostream>
#include <string>

using namespace std;
int main() {
	string a, b;
	string aa, bb;
	cin >> a >> b;
	aa = a;
	bb = b;
	int x = 0;
	for (int i = a.size() - 1; i >= 0; i--) {
		aa[x] = a[i];
		x++;
	}
	x = 0;
	for (int i = b.size() - 1; i >= 0; i--) {
		bb[x] = b[i];
		x++;
	}
	int xx = atoi(aa.c_str());    //atoi ��� �� �� string���� c_str()�� �ٿ�����Ѵ�.
	int yy = atoi(bb.c_str());
	if (xx > yy) {
		cout << xx;
	}
	else {
		cout << yy;
	}
	/*
	===============================================
	string���� int(string to int)
	===============================================
	string x = "123";
	int test = atoi(x.c_str());

	===============================================
	int���� string(int to stirng)
	===============================================
	int test = 5;
	string str = to_string(test);

	*/
	return 0;
}