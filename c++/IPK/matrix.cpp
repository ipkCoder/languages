#include <iostream>
#include <vector>
#include <algorithm>
#include <ctime>
#include <cassert>
using namespace std;

class matrix {
friend matrix operator*(matrix& m1, matrix& m2);
//friend vector<int>& operator[](const int& idx);

//protected:
public:
    vector< vector<int> > mat;
    
public:
    int n_rows;
    int n_cols;
    matrix();
    matrix(int, int, int);
    void print();
    //matrix operator*(const matrix& m1, const matrix& m2);
    vector<int>& operator[](const int& idx);
};

matrix::matrix() : mat()
{}

matrix::matrix(int r, int c, int v=0)
    : n_rows(r), n_cols(c), mat(r, vector<int>(c, v))
{}

void matrix::print() {
    for (auto v : mat) {
        for(auto x : v)
            cout << "[" << x << "] ";
        cout << endl;
    }
}

vector<int>& matrix::operator[](const int& idx) {
    return mat[idx];
}

matrix operator*(matrix& m1, matrix& m2) {
    
    assert(m1.n_cols == m2.n_rows);

    matrix m(m1.n_rows, m2.n_cols);

    int i, j, k;
    for(i = 0; i < m1.n_rows; ++i)
        for(j = 0; j < m2.n_cols; ++j)
            for (k = 0; k < m2.n_rows; ++k) {
                cout << "(" << i << " , " << j << ") Muliply : " << m1[i][j] << " " << m2[k][j] << endl;
                m[i][j] += m1[i][k] * m2[k][j];
            }
    return m;
}

//==========================================================
int main() {
    matrix m(10, 6, 5);
    m.print();
    matrix m2(1, 10, 2);
    m2.print();
    matrix m3 = m2*m;
    m3.print();
}
