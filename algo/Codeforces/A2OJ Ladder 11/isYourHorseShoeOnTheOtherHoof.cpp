//24min
#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    string s;
    set<int> _set;
    int cnt = 0;
    getline(cin,s);
    stringstream ss(s);
    string seg;
    while (getline(ss,seg,' ')){
        _set.insert(stoi(seg));
        cnt+=1;
    }
    cout << cnt-_set.size()<<endl; 

    return 0 ;
}