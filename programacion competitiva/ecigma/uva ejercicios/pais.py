from sys import stdin
def comparar(x, a):
    if a[0]==x[0] or a[1]==x[1]:
        print("divisa")
    elif a[0] <x[0] and a[1] >x[1]:
        print("NO")
    elif a[0] >x[0] and a[1] >x[1]:
        print("NE")
    elif a[0] >x[0] and a[1] <x[1]:
        print("SE")
    elif a[0] <x[0] and a[1] <x[1]:
        print("SO")
def main():
    n = int(stdin.readline())
    while n != 0:
        ejeCentral = [int(r) for r in stdin.readline().strip().split()]
        for i in range(n):
            s = [int(x) for x in stdin.readline().strip().split()]
            comparar(ejeCentral,s)
        n = int(stdin.readline())
main()
