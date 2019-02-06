from sys import stdin
def apariciones(lista,palabra):
    n=0
    for x in range(len(lista)):
        if lista[x]==palabra:
            n+=1
    return n
def contador(lista):
    y = []
    for palabra in lista:
        k = apariciones(lista,palabra)
        palabra = palabra+" "+str(k)
        y.append(palabra)
    return y
def separator(lista):
    while "," in lista:
        lista.remove(",")
    while "." in lista:
        lista.remove(".")
    return lista
def listaUnica(lista):
    listuni= []
    for x in lista:
        if x not in listuni:
            listuni.append(x)
    return listuni
def main():
    parrafo= stdin.readline().strip()
    while len(parrafo) != 0:
        print("....................")
        parrafo = list(parrafo)
        parrafo = separator(parrafo)
        parrafo= "".join(parrafo)
        parrafo = contador(parrafo.split())
        parrafo.sort()
        parrafo = listaUnica(parrafo)
        for x in parrafo:
            print(x)
        parrafo= stdin.readline().strip()
main()
