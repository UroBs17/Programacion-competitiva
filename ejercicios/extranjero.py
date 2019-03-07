from sys import stdin
def main():
    dicci = {}
    palabras = stdin.readline().strip().split()
    while len(palabras) != 0:
        dicci[palabras[1]]=palabras[0]
        palabras = stdin.readline().strip().split()
    traducir = stdin.readline().strip()
    while len(traducir) != 0:
        if traducir in dicci:
            print(dicci[traducir])
        else:
            print("eh")
        traducir = stdin.readline().strip()
main()
    
