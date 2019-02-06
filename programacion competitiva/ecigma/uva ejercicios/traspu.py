from sys import stdin
def cambio(y):
    h = []
    for i in range(len(y[0])):
        fila = [0]*len(y)
        for j in range(len(y)):
            fila[j] = y[j][i]
        h.append(fila)
    return h
def imprimir(num, h):
    print("Matriz",num,":")
    for i in range(len(h)):
        print(h[i])
def main():
    casos = int(stdin.readline())
    for i in range(casos):
        y =[]
        filas, columnas = (int(x) for x in stdin.readline().strip().split())
        for fi in range(filas):
            y.append([int(h)for h in stdin.readline().strip().split(",")])
        rta = cambio(y)
        imprimir(i+1,rta)
main()
