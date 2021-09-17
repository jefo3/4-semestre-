#include <bits/stdc++.h>
#include <iostream>
#include <stack>

#define MIN_VALUE -1e9
using namespace std;

int lis(vector<int> a) {
    int n = a.size();
    vector<int> d(n);
    for (int i = 0; i < n; i++) {
      d[i] = 1;
      for (int j = 0; j < i; j++) {
          if (a[j] < a[i])
              d[i] = max(d[i], d[j] + 1);
      }
    }

    int ans = d[0];
    for (int i = 1; i < n; i++) {
        ans = max(ans, d[i]);
    }
    return ans;
}

int main() {
  vector<int> V = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
  int f = lis(V);
  cout<< f<<endl;
  return 0;
}