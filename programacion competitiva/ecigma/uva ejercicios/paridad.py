from sys import stdin
def veri(matriz):
    filas = []
    column= []
    for i in range(len(matriz)):
        sumcol= 0
        for j in range(len(matriz)):
            sumcol += matriz[j][i]
        if sum(matriz[i])%2 == 1:
            filas.append(i+1)
        if sumcol%2 ==1:
            column.append(i+1)
    if len(filas)==0 and len(column)==0:
        return 1
    elif len(filas)>=2 or len(column)>=2:
        return 2
    else:
        return filas[0],column[0]
def shift(matriz, tam):
    return 2,3
def main():
    tam = int(stdin.readline())
    while tam != 0:
        y = []
        for j in range(tam):
            y.append([int(x) for x in stdin.readline().split()])
        if veri(y) == 2:
            print("Corrupt")
        elif veri(y) == 1:
            print("OK")
        else:
            fil,col= veri(y)
            print("Change bit ("+str(fil)+","+str(col)+")")
        tam = int(stdin.readline())
main()
