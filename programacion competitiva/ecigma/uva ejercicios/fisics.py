from sys import stdin

def main():
    n=stdin.readline().strip()
    while len(n)!=0:
        a,b=[int(x) for x in n.split()]
        print(a*b*2)
        n=stdin.readline().strip()
main()
