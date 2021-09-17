def dfa(string, current, edges, accepting):
    if string == "":
        return current in accepting
    else:
        letter = string[0]
        remainder = string[1:]
        if (current, letter) in edges:
            newstate = edges[(current, letter)]
            return dfa(remainder, newstate, edges, accepting)
        return False

initial = 0
edges = {}
edges[(0,'-')] = 1
edges[(0,'+')] = 1
edges[(0,'.')] = 2
for i in range(10):
  edges[(0, str(i))] = 3

edges[(1, '.')] = 2
for i in range(10):
  edges[(1, str(i))] = 3

edges[(3, '.')] = 5
for i in range(10):
  edges[(3, str(i))] = 3

for i in range(10):
  edges[(2, str(i))] = 4
for i in range(10):
  edges[(4, str(i))] = 4

for i in range(10):
  edges[(5, str(i))] = 5

accepting = [4,5]
string = input()
print( dfa(string, initial, edges, accepting) )