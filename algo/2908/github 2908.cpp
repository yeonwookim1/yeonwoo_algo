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
	int xx = atoi(aa.c_str());    //atoi 사용 할 때 string형은 c_str()을 붙여줘야한다.
	int yy = atoi(bb.c_str());
	if (xx > yy) {
		cout << xx;
	}
	else {
		cout << yy;
	}
	/*
	===============================================
	string에서 int(string to int)
	===============================================
	string x = "123";
	int test = atoi(x.c_str());

	===============================================
	int에서 string(int to stirng)
	===============================================
	int test = 5;
	string str = to_string(test);

	*/
	return 0;
}