from sys import stdin
def media(lista):
    num = lista[0]
    lista.remove(lista[0])
    average = sum(lista)/num
    return average
def encima(lista, media, cant, y):
    for elem in lista:
        if elem > media:
            y.append(elem)
    porc = ((len(y)*100)/cant)
    redondeo = "%.3f" %porc
    print(redondeo+"%")
def main():
    cases = int(stdin.readline())
    for i in range(cases):
        lista = [int(x) for x in stdin.readline().strip().split()]
        encima(lista,media(lista),len(lista),[])
main()
