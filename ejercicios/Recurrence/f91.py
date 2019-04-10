from sys import stdin
def f91(n):
    if n>=101:
        return n-10
    else:
        return(f91(f91(n+11)))
def main():
    while True:
        n=int(stdin.readline())
        if n==0:break
        if n>=101:
            print("f91({}) = {}".format(n,n-10))
        else:
            print("f91({}) = 91".format(n))
main()
