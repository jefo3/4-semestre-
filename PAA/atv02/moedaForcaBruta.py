def combenicao(notas):
  return True

def verifica(x):
  v = [50, 20, 20, 5, 2]
  comb = 0
  for i in range(len(v)):
    for j in range(i, len(v)):
      for y in range(j, len(v)):
        comb = comb + v[y]
      if(comb == x): 
        return True
  return False

a = int(input())
print(verifica(a))