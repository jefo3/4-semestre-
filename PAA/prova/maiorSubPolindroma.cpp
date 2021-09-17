// Longest Palindromic Subsequence - Dynamic Programming

#include <iostream>
#include <algorithm>

using namespace std;

int lps(string & s, int size_s)
{
	int mat[size_s][size_s];

	// strings de tamanho 1 são palíndromos de tamanho 1
	for(int i = 0; i < size_s; i++)
		mat[i][i] = 1;

	int tam = 2;

	while(tam <= size_s)
	{
		for(int i = 0, j = tam - 1 + i; j < size_s; i++, j++)
		{
			if(s[i] == s[j] && tam == 2)
				mat[i][j] = 2;
			else if(s[i] != s[j])
				mat[i][j] = max(mat[i][j - 1], mat[i + 1][j]);
			else
				mat[i][j] = mat[i + 1][j - 1] + 2;
		}
		tam++;
	}

	return mat[0][size_s - 1];
}

int lps2(string & s, int size_s)
{
	int mat[size_s][size_s];

	// strings de tamanho 1 são palíndromos de tamanho 1
	for(int i = 0; i < size_s; i++)
		mat[i][i] = 1;

	//int tam = 2;

	for(int i = 0; i < size_s; i++)
	{
		for(int j = 1 ; j < size_s; j++)
		{
			
			if(s[i] != s[j])
				mat[i][j] = max(mat[i][j-1], mat[i][j]);
			else
				mat[i][j] = mat[i][j-1] + 1;
		}
		
	}

	return mat[0][size_s - 1];
}

//USAR ESSE PARA RESPONDER 04
int lcs( string & X, int n ) 
{ 
    int vec[n + 1][n + 1]; 
    int i, j;
		string aux;

		for(int k = 0; k < n; k++){
			aux[k] = X[n-k-1];
		}
    
    /* Following steps build L[m+1][n+1] in 
       bottom up fashion. Note that L[i][j] 
       contains length of LCS of X[0..i-1]
       and Y[0..j-1] **/

    for (i = 0; i <= n; i++) 
    { 
        for (j = 0; j <= n; j++) 
        { 
        if (i == 0 || j == 0) 
            vec[i][j] = 0; 
      
        else if (X[i - 1] == aux[j - 1]) 
            vec[i][j] = vec[i - 1][j - 1] + 1; 
      
        else
            vec[i][j] = max(vec[i - 1][j], vec[i][j - 1]); 
        } 
    } 
          
    /* L[m][n] contains length of LCS 
    for X[0..n-1] and Y[0..m-1] */
    return vec[n][n]; 
} 
 
int main(int argc, char *argv[])
{
	string s("ACGTGTCAAAATCG");

	cout << lps(s, s.size()) << endl;
	cout << lps2(s, s.size()) << endl;

      
  cout << "Length of LCS is " << lcs( s, s.size() ) <<endl; 

	return 0;
}