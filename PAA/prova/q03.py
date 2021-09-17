def algoritmo_divisao_e_conquista(X, L, U):
        if L > U:
            return 0.0
        if L == U:
            return max(0.0, X[L - 1])
           
        M = (L + U) / 2
        soma = 0.0
        max_a_esquerda = 0.0
        for i in range(M, 0, -1):
            soma = soma + X[i - 1]
            max_a_esquerda = max(max_a_esquerda, soma)
        soma = 0.0
        max_a_direita = 0.0
        for I in range(M + 1, U + 1):
            soma = soma + X[I - 1]
            max_a_direita = max(max_a_direita, soma)
        max_C = max_a_esquerda + max_a_direita
                   
        max_A = algoritmo_divisao_e_conquista(X, L, M)
        max_B = algoritmo_divisao_e_conquista(X, M + 1, U)
        return max(max_C, max_A, max_B)


a = [10,5,-17,20,50,-1,3,-30,10]
N = len(a)
resposta = algoritmo_divisao_e_conquista(a, 1, N)
print(resposta)


//resposta da 03


MAX-1(A,n)
    vec <- aloca vetor(n)
    para x de 0 ate n:
        vec[i] = Api + Aci // vec vai receber a soma de gols feitos + gols Sofridos

    maximo <- 0
    inicio <- 0
    fim <- −1

    i <- 1
    soma <- 0
    para f <- 1 até n:
        se soma + vec[f] < 0:
            então i <- f + 1 
                soma <- 0
        senão soma <- soma + vec[f]
        se soma > maximo então
            maximo <- soma
            inicio <- i
            fim <- f
    retorne inicio, fim
