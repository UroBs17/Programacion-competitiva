from sys import stdin
def contador(pal):
    n = 0
    lista = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
    dicci = {"A":1,"B":2,"C":3,"D":4,"E":5,"F":6,"G":7,"H":8,"I":9,"J":10,"K":11,"L":12,"M":13,"N":14,"O":15,"P":16,"Q":17,"R":18,"S":19,"T":20,"U":21,"V":22,"W":23,"X":24,"Y":25,"Z":26}
    for i in range(len(pal)):
        if pal[i] in lista:
            n += dicci[pal[i]]
    veri = str(sum([int(x) for x in list(str(n))]))
    while len(veri) != 1:
        veri = [int(x) for x in list(veri)]
        veri = str(sum(veri))
    return veri
def porc(num1, num2):
    if num2 == 0 or num1 == 0:
        print("0.00 %")
    else:
        porcentaje = num2*100/num1
        print("%.2f" %porcentaje,"%")
def main():
    palabra1 = stdin.readline().strip().upper()
    while len(palabra1) != 0:
        palabra2 = stdin.readline().strip().upper()
        h = [palabra1,palabra2]
        num1, num2 =contador(h[0]),contador(h[1])
        y = [int(num1),int(num2)]
        porc(max(y),min(y))
        palabra1 = stdin.readline().strip().upper()
    print()
main()
