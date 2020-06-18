#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {

    // #ifndef ONLINE_JUDGE
    // freopen("input.txt", "r", stdin) ;
    // freopen("output.txt", "w", stdout) ;
    // #endif
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n;
    cin >> n;
    map<int,int> myMap;
    for (int i=0;i<n;i++){
        int num;
        cin >> num;
        if (myMap[num]==0)
            myMap[num]=1;
        else
            myMap[num]+=1;
    }
    int ans1=0,ans2=0,ans3=0;
    for (int i=0;i<n/3;i++){
        if (myMap[1]&&myMap[2]&&myMap[4]){
            ans3++; myMap[1]--;myMap[2]--;myMap[4]--;
        }
        else if (myMap[1]&&myMap[2]&&myMap[6]){
            ans1++; myMap[1]--;myMap[2]--;myMap[6]--;
        }
        else if (myMap[1]&&myMap[3]&&myMap[6]){

            ans2++; myMap[1]--;myMap[3]--;myMap[6]--;
        }
        else{
            cout << -1 << endl;
            return 0;
        }
    }
    while(ans1--) cout << 1 << " " << 2 << " " << 6 << endl;
    while(ans2--) cout << 1 << " " << 3 << " " << 6 << endl;
    while(ans3--) cout << 1 << " " << 2 << " " << 4 << endl;
    
    return 0 ;
}