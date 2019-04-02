from sys import stdin
def quick(lista):
    if len(lista) == 0:
        return []
    else:
        mitad = lista[-1]
        men, may = quick(menor(lista,mitad)),quick(mayor(lista,mitad))
        return men + [mitad] + may
def menor(lista,mitad):
    y = []
    for x in lista[:-1]:
        if x < mitad:
            y.append(x)
    return y
def mayor(lista,mitad):
    y = []
    for x in lista[:-1]:
        if x >= mitad:
            y.append(x)
    return y
def main():
    num = int(stdin.readline())
    while num != 0:
        lista = [int(x) for x in stdin.readline().strip().split()]
        print(" ".join([str(x) for x in quick(lista)]))
        num = int(stdin.readline())
main()
