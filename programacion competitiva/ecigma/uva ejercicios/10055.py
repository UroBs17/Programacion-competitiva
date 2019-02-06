from sys import stdin

def main():
    while True:
        a=stdin.readline().strip()
        if len(a)==0:break
        n,m=[int(x) for x in a.split()]
        print(abs(n-m))
main()
