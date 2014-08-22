#include <iostream>
#include <algorithm>
#include <thread>
#include <vector>
using namespace std;

int main() {

    vector<float> v(10);
    int i;
    for(i = 0; i < v.size(); ++i)
        v[i] = i;

    for(auto i : v) {
        cout << i << " ";
    }
    cout << endl << endl;

    random_shuffle(v.begin(), v.end());

    for(auto i : v) {
        cout << i << " ";
    }
    cout << endl << endl;

    iota(v.begin(), v.end(), -2);

    for(auto i : v) {
        cout << i << " ";
    }
    cout << endl << endl; //why doesn't iota work off of shuffled vector?
}
