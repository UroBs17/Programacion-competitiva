from sys import stdin

a= int(stdin.readline())

def fib(n):
    if n!=0 and n != 1:
        return fib(n-1)+fib(n-2)
    elif n==1:
        return 1
    else:
        return 0
def main():
    print(fib(a))
main()
