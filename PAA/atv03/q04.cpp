#include <algorithm>
#include <bits/stdc++.h>
#include <iostream>
#include <stack>

#define MAX_VALUE 1e9
using namespace std;

int max_sum(vector<int> s){
	
	int resp=0, maior=0;
	
	for(int i=0;i<s.size();i++){
		
		maior=max(0,maior+s[i]);
		
		resp=max(resp,maior);
	}
	
	return resp;
}

int sum(vector<int> A){
  int n = A.size();
  vector<int> vec(n);
  vec[0] = A[0];
  for(int i = 1; i < n; i++){
    vec[i] = A[i];
    if(vec[i-1] >= 0){
      vec[i] = vec[i] + vec[i-1];
    }
  }
  int x = vec[0];
  for(int i = 1; i < n; i++){
    x = max(x, vec[i]);
  }

  return x;
}


int main() {
  vector<int> V = {20, 	 -30, 	 -15, 	 -10, 	 -30, 	 -20, 	 -30, 	 30};
  
  int f = max_sum(V);
  cout << f << endl;

  int j = sum(V);
  cout << j << endl;
  
  return 0;
}


