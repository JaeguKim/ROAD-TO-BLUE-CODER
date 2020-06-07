//10min
#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    string s;
    cin >> s;
    stringstream ss(s);
    string seg;
    vector<int> v;
    while (getline(ss,seg,'+')){
        v.push_back(stoi(seg));
    }
    sort(v.begin(),v.end());
    for (int i=0; i<v.size()-1;i++){
        cout << v[i]<<"+";
    }
    cout<<v[v.size()-1]<<endl;
    return 0 ;
}