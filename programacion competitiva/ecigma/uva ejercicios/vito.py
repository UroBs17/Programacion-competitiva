from sys import stdin
def numero(lista):
    pivote = lista[len(lista)//2]
    listsum= [abs(x-pivote) for x in lista]
    return sum(listsum)
def main():
    casos = int(stdin.readline())
    for i in range(casos):
        lista = [int(x) for x in stdin.readline().strip().split()]
        del lista[0]
        lista.sort()
        print(numero(lista))
main()
