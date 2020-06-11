//integer 범위가 32억이 넘어갈때는 long long이나 unsigned long long을 사용한다.
//풀이는 대략적으로 맞았으나, long long 범위가 넘어갔다.
//TIME : 48min 30sec
#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

const int N = 1e5+1;
int pos[N];
int n,m;

int main(){
    cin >> n;
    for (int i=1; i<=n;i++){
        int num;
        cin >> num;
        pos[num] = i;
    }
    cin >> m;
    ll sum1=0,sum2=0;
    for (int i=0;i<m;i++){
        int b;
        cin >> b;
        sum1 += pos[b];
        sum2 += n+1-pos[b];
    }
    cout << sum1 << " " << sum2 << endl;
}