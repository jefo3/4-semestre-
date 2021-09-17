multiMatriz(a[][], k):
    se k == 1
        retorna a

    matriz aux <- multiMAtriz(a, k/2)

    c <- aloca matriz (n)(n);
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++){
            for(x = 0; x < n; x++){
                
                c[i][j] += aux[i][x] * aux[x][j];
            
            }
            //se o k for impa tem q realizar a multpicação de novo
            if(k%2==1){
                for(x = 0; x < n; x++){
                
                    c[i][j] += aux[i][x] * a[x][j];
            
                }   
            }
        }
    }
    
    retorna c

