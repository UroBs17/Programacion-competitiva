from sys import stdin
def floyd_warshall(g):
    h=len(g)
    for k in range(h):
        for i in range(h):
            for j in range(h):
                g[i][j]=max(g[i][j],g[i][k]*g[k][j])
    return g
def main():
    n=int(stdin.readline())
    f=1
    while n:
        g=[[0 for i in range(n)] for j in range(n)]
        dic={}
        for i in range(n):
            dic[stdin.readline().strip()]=i
        arcs=int(stdin.readline())
        for j in range(arcs):
            x,p,y=stdin.readline().strip().split()
            g[dic[x]][dic[y]]=float(p)
        h=floyd_warshall(g)
        veri=False
        for i in range(n):
            if h[i][i]>1:
                veri=True
        if veri:
            print("Case "+str(f)+": Yes")
        else:
            print("Case "+str(f)+": No")
        f+=1
        stdin.readline()
        n=int(stdin.readline())
main()
