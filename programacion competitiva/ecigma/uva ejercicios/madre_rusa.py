from sys import stdin
def solve(lista):
    pila=[]
    interruptor=True
    for elem in lista:
        if elem >0:
            if len(pila)==0 or pila[-1][0]!= -1*elem:
                interruptor=False
                break
            else:
                pila.pop()
        else:
            if len(pila)==0:
                pila.append([elem,-1*elem])
            elif len(pila)>0 and pila[-1][1] > -1*elem:
                pila[-1][1]-=(-1*elem)
                pila.append([elem,-1*elem])
            else:
                interruptor=False
                break
    if not interruptor or len(pila)>0:
        print(":-( Try again.")
    else:
        print(":-) Matrioshka!")
def main():
    lista=[int(x) for x in stdin.readline().strip().split()]
    while len(lista)!=0:
        solve(lista)
        lista=[int(x) for x in stdin.readline().strip().split()]
main()
