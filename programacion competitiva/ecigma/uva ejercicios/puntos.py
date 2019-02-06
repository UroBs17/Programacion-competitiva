from sys import stdin

def puntos(n):
    if n>1:
        x = puntos(n-1)+(3*n)-2
        print(x)
        return x
    else:
        print(1)
        return 1
def main():
    a = int(stdin.readline())
    puntos(a)
main()
