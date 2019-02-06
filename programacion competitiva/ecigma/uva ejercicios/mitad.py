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
def mitad(lista):
    if len(lista)%2 == 0:
        mitad = (lista[len(lista)//2]+lista[(len(lista)//2)-1])//2
    else:
        mitad = lista[len(lista)//2]
    return mitad
def main():
    """Para este programa use la funcion de ord que use en el de la edad"""
    num = stdin.readline().strip()
    y = []
    while len(num) != 0:
        elem = int(num)
        y.append(elem)
        print(mitad(quick(y)))
        num = stdin.readline().strip()
main()
        
