from sys import stdin
def modulo(x,y):
    if x<0:
        x = -x
        return -(x%y)
    else:
        return x%y
def quick(lista,y):
    if len(lista)==0:
        return []
    else:
        pivote = lista[0]
        izq,der=quick([x for x in lista[1:] if modulo(x,y) < modulo(pivote,y)],y),quick([x for x in lista[1:] if modulo(x,y) >= modulo(pivote,y)],y)
        return izq+[pivote]+der
def mayImp(lista, y):
    for i in range(1,len(lista)):
        for j in range(len(lista)-i):
            if lista[j]%2==0 and lista[j+1]%2==1 and lista[j]%y == lista[j+1]%y:
                lista[j],lista[j+1]=lista[j+1],lista[j]
    return lista
def maypaim(lista, y):
    for i in range(1,len(lista)):
        for j in range(len(lista)-i):
            if lista[j] < lista[j+1] and lista[j]%y == lista[j+1]%y and lista[j]%2 == 1 and lista[j+1]%2==1 :
                lista[j],lista[j+1]=lista[j+1],lista[j]
            elif lista[j] > lista[j+1] and lista[j]%y == lista[j+1]%y and lista[j]%2 == 0 and lista[j+1]%2==0:
                lista[j],lista[j+1]=lista[j+1],lista[j]
    return lista
def main():
    caso = [int(x) for x in stdin.readline().strip().split()]
    while caso != [0,0]:
        y = []
        print(caso[0],caso[1])
        for i in range(caso[0]):
            y.append(int(stdin.readline()))
        y = quick(y, caso[1])
        y = mayImp(y, caso[1])
        y = maypaim(y, caso[1])
        for x in y:
            print(x)
        caso = [int(x) for x in stdin.readline().strip().split()]
    print("0 0")
main()
