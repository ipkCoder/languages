//g++-4.7 -std=c++11 maps.cpp -o maps 
#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
//#include <cstddef>
#include <ctime>
using namespace std;

// template<typename T>
// using Iterator<T> = typename T::iterator;

// template<typename C, typename V>
// vector<Iterator<C>> find_all(C c, V v) {
// 	vector<Iterator<C>> found;
// 	for(auto p = c.begin(); p != c.end(); ++p) {
// 		if(*p == v)
// 			found.push_back(p);
//  	}
//  	return found;
// }

template<typename C, typename V>
vector<typename C::iterator> find_all(C c, V v) {
	vector<typename C::iterator> found;
	for(auto p = c.begin(); p != c.end(); ++p) {
		if(*p == v)
			found.push_back(p);
 	}
 	return found;
}

int main() {

	multimap<int, float, less<int> > mMap;
	map<int, float, less<int> > m;
	vector<int> v;
	
	// ========== fill ==========
	// for map, duplicate key will replace old value
	srand(time(NULL));
	int i;
	for(i = 0; i < 30; ++i) {
		float r = float(rand())/RAND_MAX;
		mMap.insert( {i%3, r} );
		m.insert( {i%3, r} );
		v.push_back(r);
	}

	// ===== add key value pair =========
	m[500] = 76.0;

	// ========= print maps ===========
	// for loop returns "pair" for maps
	int start = clock();
	cout << "Key\tValue" << endl;
	
	for(auto item : mMap) {
		cout << item.first << "\t" << item.second << endl;
	}
	cout << endl << endl;
	for(auto item : m) {
		cout << item.first << "\t" << item.second << endl;
	}

	cout << endl << "Print map. Time in sec: " << float((clock() - start))/CLOCKS_PER_SEC << endl;

	// ======== find and erase ===========

	// find returns iterator to found item or iterator at one passed end 
	map<int, float>::iterator mit;

	mit = m.find(500);
	m.erase(mit);

	cout << endl;
	for(auto item : m) {
		cout << item.first << "\t" << item.second << endl;
	}

	// ========= count all values > ___ ==========
	int c = count_if(mMap.begin(), mMap.end(), [](const pair<int, float>& p){return p.second > .5;});
	cout << "Count > .5 in multimap = " << c << endl;

	// ===== get all values of ____ =====
	vector<string> vs {"red", "blue", "green", "yellow", "green"};

	for(auto p : find_all(vs, "green")) {
		if(*p != "green")
			cout << "vector bug";
		else
			cout << *p << endl;
	}

	// ======= syntax =======
	cout << m.find(1)->second << endl;

}
