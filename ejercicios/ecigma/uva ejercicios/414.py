from sys import stdin

def main():
    while True:
        n=int(stdin.readline())
        if n==0:break
        mi=float("inf")
        l=[]
        for i in range(n):
            line=stdin.readline().strip()
            x=line.count(" ")
            mi=min(mi,x)
            l.append(x)
        rta=0
        for i in l:
            rta+=(i-mi)
        print(rta)
main()
