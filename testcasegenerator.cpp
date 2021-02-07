#include<bits/stdc++.h>
using namespace std;
int main(){

    int n,k;
    cin>>n>>k;
    cout<<n<<" "<<k<<"\n";
    for(int i=1;i<=n;i++){
        cout<<rand() % 50 + 1<<" "<<rand() % 10000 + 1<<"\n";
    }

    return 0;
}
