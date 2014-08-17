#include <iostream>
#include <thread>
#include <vector>
using namespace std;

void f(const int& x1, const int& x2, int* result) {
    *result = x1+x2;
}

int main() {

    vector<int> x(10,2);
    vector<int> y(10,3);
    vector<int> z(10);
    vector<thread> threads;

    // ======= add vectors using threads ==========
    int i;
    for(i = 0; i < 10; ++i) {
        threads.push_back(thread(f, x[i], y[i], &z[i]));
    }
    // ====== wait for threads to finish =========
    for(auto& thread : threads){
        thread.join();
    }
    // print
    for(auto& a : z){
        cout << a << endl;
    }
    
    return 0;
}
