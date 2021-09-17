import re


## Coloque aqui usa expressão regular
regexp = r'[0][xX][0-9 | a-f | A-F]+'


for string in input().split(' '):
  print( re.fullmatch(regexp, string) != None)