#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

const int N = 1e3+5;
int n;
int a[N],b[N];

int main()  
{  
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int t=1;
    cin >> t;
    while (t--){
        cin >> n;
        bool sorted = true, have0 = false, have1 = false;
        for (int i=1; i<=n;i++){
            cin >> a[i];
            if (i >= 2 && a[i-1] > a[i]){
                sorted = false;
            }
        }
        for (int i=1; i<=n; i++){
            cin >> b[i];
            if (b[i] == 1){
                have1 = true;
            }
            else{
                have0 = true;
            }
        }
        if (sorted){
            cout << "Yes" << endl;
        }
        else if (have1 && have0){
            cout << "Yes" << endl;
        }
        else{
            cout << "No" << endl;
        }
    }
    return 0;  
}  
  