from sys import stdin

def main():
    n=int(stdin.readline())
    for i in range(n):
        s=0
        farmers=int(stdin.readline())
        for j in range(farmers):
            a,b,c=[int(x) for x in stdin.readline().strip().split()]
            s+=(a*c)
        print(s)
main()
