#include <bits/stdc++.h>
#include <iostream>
#include <stack>

#define MAX_VALUE 1e9
using namespace std;

int dinamic(vector<int> V, vector<int> P, int M) {
  int n = V.size();
  int vec[n + 1][M + 1];

  for (int i = 0; i <= M; i++) {
    vec[0][i] = 0;
  }
  for (int j = 0; j <= n; j++) {
    vec[j][0] = 0;
  }

  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= M; j++) {

      if (P[i - 1] <= j) {
        vec[i][j] = max(V[i - 1] + vec[i - 1][j - P[i - 1]], vec[i - 1][j]);
        // if (V[i - 1] + vec[i - 1][w - P[i - 1]] > vec[i - 1][w]) {
        //   vec[i][w] = V[i - 1] + vec[i - 1][w - P[i - 1]];
        // } else {
        //   vec[i][w] = vec[i - 1][w];
        // }

      } else {
        vec[i][j] = vec[i - 1][j];
      }
    }
  }
  return vec[n][M];
}

int main() {
  vector<int> V = {3, 5, 8, 4, 10, 12};
  vector<int> P = {2, 4, 5, 3, 9, 9};
  int W = 9;

  int f = dinamic(V, P, W);
  cout << f << endl;
  return 0;
}