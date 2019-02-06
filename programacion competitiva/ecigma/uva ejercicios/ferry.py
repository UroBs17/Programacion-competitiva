from sys import stdin
def solve(izq,der,lr,m):
    n=0
    temp=lr
    while len(izq)>0 or len(der)>0:
        if len(izq)>0 and lr-izq[0]>=0 :
            lr-=izq[0]
            if len(izq)==1 and len(der)==0:
                n+=1
            izq.pop(0)
        else:
            lr=temp
            n+=1
            while len(der)>0:
                if len(der)>0 and lr-der[0]>=0:
                    lr-=der[0]
                    der.pop(0)
                else:
                    break
            n+=1
            lr=temp
    print(n)
def main():
    n=int(stdin.readline())
    for i in range(n):
        l,m=[int(x) for x in stdin.readline().strip().split()]
        lr=l*100
        izq=[]
        der=[]
        for i in range(m):
            g=stdin.readline().strip().split()
            if g[1]=="left":
                izq.append(int(g[0]))
            else:
                der.append(int(g[0]))
        solve(izq,der,lr,m)
main()

