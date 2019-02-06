from sys import stdin
def aumen(y):
    for i in range(len(y)):
        for j in range(len(y)):
            y[i][j] += 1
            if y[i][j] == 10:
                y[i][j] = 0
    return y
def decre(y):
    for i in range(len(y)):
        for j in range(len(y)):
            y[i][j] = y[i][j]-1
            if y[i][j] == -1:
                y[i][j] = 9
    return y
def fila(y,a,b):
    for i in range(len(y)):
        y[a][i],y[b][i] = y[b][i],y[a][i]
    return y
def colu(y,a,b):
    for i in range(len(y)):
        y[i][a],y[i][b] = y[i][b],y[i][a]
    return y
def tras(y):
    h = []
    for i in range(len(y[0])):
        fila = [0]*len(y)
        for j in range(len(y)):
            fila[j] = y[j][i]
        h.append(fila)
    return h
def main():
    casos = int(stdin.readline())
    for i in range(casos):
        tam = int(stdin.readline())
        y = []
        for j in range(tam):
            y.append([int(x) for x in list(stdin.readline().strip())])
        cant= int(stdin.readline())
        for t in range(cant):
            operacion = stdin.readline().split()
            if operacion[0] == "transpose":
                y = tras(y)
            elif operacion[0] == "inc":
                y = aumen(y)
            elif operacion[0] == "dec":
                y = decre(y)
            elif operacion[0] == "row":
                y = fila(y,int(operacion[1])-1,int(operacion[2])-1)
            elif operacion[0] == "col":
                y = colu(y,int(operacion[1])-1,int(operacion[2])-1)
        print("Case #"+str(i+1))
        for k in range(len(y)):
            for g in range(len(y)):
                y[k][g] = str(y[k][g])
        for r in range(len(y)):
            print("".join(y[r]))
        print()
main()
