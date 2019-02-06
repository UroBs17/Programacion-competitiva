from sys import stdin
def gradoDes(cadena):
    n = 0
    for i in range(len(cadena)):
        for j in range(i+1, len(cadena)):
            if cadena[i] > cadena[j]:
                n += 1
    return n
def quick(lista):
    if len(lista) == 0:
        return []
    else:
        mitad = lista[-1]
        men, may = quick([x for x in lista[:-1] if gradoDes(x) <= gradoDes(mitad)]),quick([x for x in lista[:-1] if gradoDes(x) > gradoDes(mitad)])
        return men + [mitad] + may
def main():
    casos = int(stdin.readline())
    for i in range(casos):
        lineBlanco = stdin.readline()
        lon, cant= [int(x) for x in stdin.readline().strip().split()]
        y = []
        for t in range(cant):
            y.append(stdin.readline().strip())
        y = quick(y)
        for x in y:
            print(x)
        if i < casos-1:
            print()
main()
