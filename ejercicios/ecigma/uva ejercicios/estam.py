from sys import stdin

a = int(stdin.readline())

def estam(n):
    if n>1:
        return((2*estam(n-1))+10)+ estam(n-1)
    elif n==1:
        return 3
def main():
    print(estam(a), "estampillas")
main()
