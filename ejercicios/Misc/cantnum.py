from sys import stdin
def contador(cadena,  number):
    contador = 0
    for i in range(len(cadena)):
        if number in cadena[i]:
            contador += 1
    return contador
def cadena(numero,y):
    for i in range(1,numero+1):
        y.append(str(i))
    return y
def main():
    casos = int(stdin.readline())
    for i in range(casos):
        lista = []
        numero = int(stdin.readline())
        string = "".join(cadena(numero,[]))
        for j in range(10):
            t = contador(string,str(j))
            lista.append(str(t))
        r = " ".join(lista)
        print(r)
main()
            
    
        
        
