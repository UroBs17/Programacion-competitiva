from sys import stdin
def distancia(a,b):
    a = int(a.strip("("))
    b = int(b.strip(")"))
    distancia = a-b
    if distancia <= 0:
        return -distancia
    else:
        return distancia
def main():
    y = []
    a = int(stdin.readline())
    b = stdin.readline().strip().split(",")
    for i in range(0,a+1,2):
        d = distancia(b[i],b[i+1])
        y.append(d)
        print(b[i],",", b[i+1], "=",d)
    print("la distancia maxima es =", max(y))
main()
