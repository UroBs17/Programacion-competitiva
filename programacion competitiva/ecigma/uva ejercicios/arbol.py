from sys import stdin
import operator
def apari(lista,n):
    for i in lista:
        print(i[0]+" %.4f"%((i[1]/n)*100))
def main():
    n= int(stdin.readline())
    blank=stdin.readline()
    y=n
    for i in range(n):
        lista={}
        arbol=stdin.readline().strip()
        n=0
        while len(arbol)!=0:
            if arbol in lista:
                lista[arbol]+=1
                n+=1
            else:
                lista[arbol]=1
                n+=1
            arbol=stdin.readline().strip()
        x=sorted(lista.items(), key=operator.itemgetter(0))
        apari(x,n)
        if i != y-1:
            print()
main()
        
