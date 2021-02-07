#include<bits/stdc++.h>
using namespace std;
int main(){

    int n=499;
    int k=89;
    cout<<n<<" "<<k<<"\n";
    for(int i=1;i<=n;i++){
        cout<<rand() % 50 + 1<<" "<<rand() % 10000 + 1<<"\n";
    }

    return 0;
}
