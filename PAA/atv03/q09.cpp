#include <bits/stdc++.h>
#include <iostream>
#include <stack>

#define MIN_VALUE -1e9
using namespace std;

int HastDinamic(int P[], int B) {
  
  int vec[B+1];
  int vec2[B+1];  
  
  vec[0] = 0;

  int q;

  int i, j;
  for(i = 1; i <= B; i++){
    q = INT_MIN;
    for(j = 1; j <= i; j++){
      int aux = P[j-1] + vec[i - j];
      if (q < aux){
          q = aux;
          vec2[i] = j;
      }
      
    }
    vec[i] = q;
  }
  for(int x = 1; x <= B; x++){
    cout<<"=="<<vec2[x] <<"---"<<vec[x]<<endl;
  }
  return vec[B];
}


int main() {
  int V[] = {1, 2, 3, 4, 5, 6, 7};
  int P[] = {1, 3, 4, 5, 7, 9, 11};
  int M = 3;
  int f = HastDinamic(P, M);
  cout << f << endl;
  
  return 0;
}



        