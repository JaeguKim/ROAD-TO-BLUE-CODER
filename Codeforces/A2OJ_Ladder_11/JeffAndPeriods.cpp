//map은 자동으로 key를 기준으로 sorting 됨
#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    map<int,vector<int>> myMap;
    int n;
    cin >> n;
    for (int i=0;i<n;i++){
        int num;
        cin >> num;
        myMap[num].push_back(i+1);
    } 
    map<int,int> ans;
    for (auto &pair : myMap){
        if (myMap[pair.first].size() == 1){
            ans[pair.first] = 0;
        }
        else{
            int period = pair.second[1]-pair.second[0];
            bool isValid = true;
            for (int i=1;i<pair.second.size();i++){
                if (period != (pair.second[i]-pair.second[i-1])){
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                ans[pair.first] = period;
        }
    }
    cout << ans.size() << endl;
    for (auto &pair : ans){
        cout << pair.first << " " << pair.second << endl;
    }
    return 0 ;
}