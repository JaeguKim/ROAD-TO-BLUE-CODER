//같은 문제를 더 쉽게 해석할때 시간을 단축시킬수 있다.
#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    int n,m;
    cin >> n >> m;
    
    for (int i=0;i<n;i++){
        string s;
        cin >> s;
        for (int j=0;j<m;j++){
            if (s[j] == '.'){
                if ((i+j)%2 == 0)
                    s[j] = 'B';
                else
                    s[j] = 'W';
            }
        }
        cout << s << endl;
    }
    return 0 ;
}