#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    ull a,b;
    int t;
    cin >> t;
    int arr[3] = {8,4,2};
    for (int i=0; i<t; i++){
        cin >> a >> b;
        ull large = max(a,b);
        ull small = min(a,b);
        ull res = 0;
        ull div = large/small;
        if (large == small){
            cout << 0 << endl;
            continue;
        }
        else if (large%small != 0){
            cout << -1 << endl;
            continue;
        }
        else{
            while (true){
                bool flag = false;
                for (int i=0; i<3; i++){
                    if (div % arr[i] == 0){
                        div/=arr[i];
                        res+=1;
                        flag = true;
                        break;
                    }
                }
                if (flag == false)
                    break;
            }
            if (div != 1){
                cout << -1 << endl;
                continue;
            }
            else{
                cout << res << endl;
            }
        }
    }
    return 0 ;
}