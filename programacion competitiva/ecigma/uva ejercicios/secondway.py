from sys import stdin
class DisjoinSet(object):
    def __init__(self, n):
        self.padre = [x for x in range(n)]
        self.rank = [0 for x in range(n)]

    def Buscar(self, x):
        if(self.padre[x]!=x):
            self.padre[x]=self.Buscar(self.padre[x])
        return self.padre[x]

    def Union(self, x, y):
        xRaiz = self.Buscar(x)
        yRaiz = self.Buscar(y)
        if(xRaiz == yRaiz):
            return
        if self.rank[xRaiz] < self.rank[yRaiz]:
            self.padre[xRaiz] = yRaiz
        elif self.rank[xRaiz] > self.rank[yRaiz]:
            self.padre[yRaiz] = xRaiz
        else:
            self.padre[yRaiz] = xRaiz
            self.rank[xRaiz]+=1
def kruskal(lista,n):
    l=DisjoinSet(n)
    rt=[]
    costo=0
    for i in range(len(lista)):
        if l.Buscar(lista[i][1])!=l.Buscar(lista[i][2]):
            costo+=lista[i][0]
            l.Union(lista[i][1],lista[i][2])
            rt.append(lista[i])
    return rt,costo
def vali(edgelist,m,n):
    secondway=False
    edgelist.sort()
    first,cost1=kruskal(edgelist,n)
    mini=2**31-1
    if len(first)!=n-1:
        return "No way"
    for i in first:
        x=edgelist.index(i)
        t=edgelist.pop(x)
        rt,cost2=kruskal(edgelist,n)
        if cost2>=cost1 and len(rt)==n-1 and cost2<mini:
            secondway=True
            mini=cost2
        edgelist.insert(x,t)
    if mini>=cost1 and mini!=2**31-1 and secondway:
        return mini
    return "No second way"
def main():
    k=int(stdin.readline())
    for h in range(k):
        n,m=[int(x) for x in stdin.readline().strip().split()]
        edgelist=[]
        f=0
        for i in range(m):
            x,y,p=[int(x) for x in stdin.readline().strip().split()]
            if x!=y:
                f+=1
            edgelist.append([p,x-1,y-1])
        if f<n-1:
            print("Case #"+str(h+1)+" : No way")
        else:
            y=vali(edgelist,m,n)
            print("Case #"+str(h+1)+" : "+str(y))
main()
