#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {

    vector<int> v1(5);
    vector<int> v2(5);

    int i;
    for (i = 0; i < 5; ++i) {
        v1[i] = i;
        v2[i] = i+1;
    }

    for(auto x : v1)
        cout << x << " ";
    cout << endl;
    for(auto x : v2)
        cout << x << " ";

    cout << "\nInner product = " << inner_product(v1.begin(), v1.end(), v2.begin(), 0) << endl;

}
