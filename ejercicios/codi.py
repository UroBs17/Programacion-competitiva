from sys import stdin

def matriz(palabra, lon):
    listaElem = list(palabra)
    mat = [listaElem[x:x+lon] for x in range(0,len(listaElem),lon)]
    return mat
def union(matriz, y):
    for i in range(len(matriz)):
        for j in range(len(matriz)):
            y.append(matriz[j][i])
    return y
def imprimir(y):
    pala = ""
    for i in range(len(y)):
        pala = pala+y[i]
    print(pala)
def main():
    casos = int(stdin.readline())
    for i in range(casos):
        palabra = stdin.readline().strip()
        cuadrado = int(len(palabra)**(1/2))
        tipo = str(len(palabra)**(1/2))
        if len(tipo) == 3:
            s = matriz(palabra, cuadrado)
            deco = union(s,[])
            imprimir(deco)
        else:
            print("INVALID")
main()
