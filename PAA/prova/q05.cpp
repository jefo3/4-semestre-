// M[n] = vetor de PD

// dict(w) retorna true ou false

// s[1...n] nossa string
construirPalavra(s,n):
	vec <- aloca vetor(n)
	vec[0] <- verdadeiro
	for(i = 1; i < n;i++ {
			q <- false;
			for(j = 1; j < i; j++) {
				if (vec[j-1] == true && dict(s[j]) == true) {
						q <- true;
				}
				vec[i] <- q
			}
		}
	}
	retorna vec[n]