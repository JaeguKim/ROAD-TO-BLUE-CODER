// TIME : 23min
// string을 개행으로 파싱하는 쉬운방법을 익힐수 있었다. 다음에는 훨씬 쉽게 풀수 있을것같다.
// 또한 map에서 초기화하는 코드를 제거하고 한줄로 간단히 표현할수 있었다.
#include <bits/stdc++.h> 
using namespace std;
 
typedef long long ll;
typedef unsigned long long ull;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL) ; cout.tie(NULL) ;
    string s1,s2;
    getline(cin,s1);
    getline(cin,s2);
    map<char,int> myMap;
    for (auto c : s1){
        myMap[c]+=1;
    }
    for (auto c : s2){
        if (c!=' ')
            if (myMap[c]==0){
                cout << "NO" << endl;
                return 0;
            }
            else{
                myMap[c]-=1;
            }
    }
    cout << "YES" << endl;
    return 0 ;
}