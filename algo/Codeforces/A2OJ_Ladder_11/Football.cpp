//TIME : 15min
#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n;
    cin >> n;
    vector<string> v;
    while (n--){
        string s;
        cin >> s;
        v.push_back(s);
    }
    int a=0,b=0;
    string team = v[0];
    string other = "";
    for (int i=0;i<v.size();i++){
        if (team == v[i]){
            a+=1;
        }
        else{
            if (other == "")
                other = v[i];
            b+=1;
        }
    }
    if (a>b)
        cout << team << endl;
    else
        cout << other << endl;
    return 0 ;
}