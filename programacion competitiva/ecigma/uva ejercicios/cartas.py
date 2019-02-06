from sys import stdin
def solve(lista):
    x=[]
    while len(lista)!=1:
        x.append(lista[0])
        del lista[0]
        lista.append(lista[0])
        del lista[0]
    x=list(map(str,x))
    if len(x)==0:
        print("Discarded cards:")
    else:
        print("Discarded cards: "+", ".join(x))
    print("Remaining card: "+str(lista[0]))
def main():
    n=int(stdin.readline())
    while n !=0:
        lista=list(set(range(1,n+1)))
        solve(lista)
        n=int(stdin.readline())
main()
        
