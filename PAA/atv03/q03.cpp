#include <bits/stdc++.h>
#include <iostream>
#include <stack>

#define MIN_VALUE -1e9
using namespace std;

int HastDinamic(int P[], int M) {
  int vec[M+1];
  int vec2[M+1];  
  
  vec[0] = 0;

  int q;

  int i, j;
  for(i = 1; i <= M; i++){
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
  for(int x = 1; x <= M; x++){
    cout<<"=="<<vec2[x] <<"---"<<vec[x]<<endl;
  }
  return vec[M];
}

int Botton_Up_Cut_Rod(int* p, int n)
{

  int q;
  int * r = new int[n + 1];
  r[0] = 0;
  for (int j = 1; j <= n; j++)
  {
      q = INT_MIN;
      for (int i = 1; i <= j; i++)
      {
          int aux = p[i-1] + r[j - i];
          if (q < aux)
          {
              q = aux;
          }
      }
      r[j] = q;
  }
  return r[n];
}

int main() {
  int V[] = {1, 2, 3, 4, 5, 6, 7};
  int P[] = {1, 3, 4, 5, 7, 9, 11};
  int M = 3;
  int f = HastDinamic(P, M);
  cout << f << endl;
  int j = Botton_Up_Cut_Rod(P, M);
  cout << j << endl;
  return 0;
}



        