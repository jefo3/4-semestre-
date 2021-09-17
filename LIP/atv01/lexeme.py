def counting_lexemes(code, lexeme):
  
  tamLexeme = len(lexeme)
  posicaoAparicao = 0
  totalAparicao = 0

  while(code.find(lexeme, posicaoAparicao) != -1):
    posicaoAparicao = code.find(lexeme, posicaoAparicao) + tamLexeme
    totalAparicao = totalAparicao + 1
  
  return totalAparicao
    
    

code = input()
lexeme = input()
print ( counting_lexemes(code, lexeme))