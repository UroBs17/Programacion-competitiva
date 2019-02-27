from sys import stdin
def monedas(lista,y):
    if  sum(y) > sum(lista):
        return len(y)
    else:
        for i in range(len(lista)-1):
            if lista[i] > lista[i+1]:
                lista[i],lista[i+1]=lista[i+1],lista[i]
        y.append(lista[-1])
        del lista[-1]
        return monedas(lista,y)
def main():
    mon = int(stdin.readline())
    lista = [int(x) for x in stdin.readline().strip().split()]
    print(monedas(lista,[]))
main()
