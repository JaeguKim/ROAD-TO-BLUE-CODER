#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int t;
    cin >> t;
    while (t--){
        vector<int> v1;
        int n;
        int maxVal = 1024;
        cin >> n;
        for (int i=0;i<n;i++){
            int num;
            cin >> num;
            v1.push_back(num);
        }   
        sort(v1.begin(),v1.end());
        vector<int> v2;
        bool isFind = false;
        for (int k=1;k<=maxVal;k++){
            for (int i=0;i<v1.size();i++){
                v2.push_back(v1[i]^k);
            }
            sort(v2.begin(),v2.end());
            if (v1 == v2){
                cout << k << endl;
                isFind = true;
                break;
            }
            v2.clear();
        }
        if (isFind == false){
            cout << -1 << endl;
        }
        v1.clear();
    }
    return 0 ;
}