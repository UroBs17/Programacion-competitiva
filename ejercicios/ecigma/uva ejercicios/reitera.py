from sys import stdin
def genList(tam, palabra):
    y = []
    for i in range(len(palabra)-tam+1):
        add = palabra[i:tam+i]
        y.append(add)
    return y
def apariciones(lista,palabra):
    n=0
    for x in range(len(lista)):
        if lista[x]==palabra:
            n+=1
    return n
def password(lista):
    for i in range(1,len(lista)):
        for j in range(len(lista)-i):
            if apariciones(lista,lista[j]) > apariciones(lista,lista[j+1]):
                lista[j],lista[j+1]=lista[j+1],lista[j]
    return lista[-1]
def main():
    palabra = stdin.readline().strip()
    while len(palabra)!=0:
        palabra = palabra.split()
        lonc , palabra= int(palabra[0]), palabra[1]
        lista = genList(lonc,palabra)
        print(password(lista))
        palabra = stdin.readline().strip()
main()
