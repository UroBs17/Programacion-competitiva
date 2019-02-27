from sys import stdin
def cambio(irre, palabra):
    d = ["a","e","i","o","u"]
    g = ["c","s"]
    if palabra in irre:
        palabra = irre[irre.index(palabra)+1]
    elif (palabra[-2] not in d) and palabra[-1]=="y":
        palabra = list(palabra)
        del palabra[-1]
        palabra.append("ies")
        palabra = "".join(palabra)
    elif palabra[-1] == "o" or palabra[-1] == "s" or palabra[-1] == "x" :
        palabra = list(palabra)
        palabra.append("es")
        palabra = "".join(palabra)
    elif (palabra[-2] in g) and palabra[-1]=="h":
        palabra = list(palabra)
        palabra.append("es")
        palabra = "".join(palabra)
    else:
        palabra = list(palabra)
        palabra.append("s")
        palabra = "".join(palabra)
    return palabra
def main():
    base, pala = [int(x) for x in stdin.readline().split()]
    irre = []
    for i in range(base):
        pal , irr = stdin.readline().split()
        irre.append(pal.lower())
        irre.append(irr.lower())
    for j in range(pala):
        palabra = stdin.readline().strip().lower()
        print(cambio(irre, palabra))
main()
