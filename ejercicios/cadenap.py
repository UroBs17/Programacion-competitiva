from sys import stdin

def elemIgual(cadena, lim1, lim2):
    if lim1 == lim2:
        print("solo hay")
    else:
        n=1
        k = lim2-lim1+1
        for x in range(lim1, lim2-1):
            if cadena[x]==cadena[x+1]:
                n +=1
        if n == k:
            print("solo hay")
        else:
            print("no hay" )
def main():
    cadena = stdin.readline().strip()
    while len(cadena) != 0:
        casos = int(stdin.readline())
        for i in range(casos):
            indice = [int(x) for x in stdin.readline().split()]
            indice.sort()
            elemIgual(cadena,indice[0],indice[1])
        print("-----------------------")
        cadena = stdin.readline().strip().split()
main()
