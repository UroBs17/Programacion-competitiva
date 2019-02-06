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
    cost=2**31-1
    for i in range(len(lista)):
        if l.Buscar(lista[i][1])!=l.Buscar(lista[i][2]):
            cost=min(cost,lista[i][0])
            l.Union(lista[i][1],lista[i][2])
    return cost
def main():
    h=int(stdin.readline())
    for k in range(h):
        n,m=[int(x) for x in stdin.readline().strip().split()]
        edgelist=[]
        for i in range(m):
            x,y,p=[int(x) for x in stdin.readline().strip().split()]
            if x!=y:
                edgelist.append([p,x,y])
        edgelist.sort(reverse=True)
        print("Case #"+str(k+1)+": "+str(kruskal(edgelist,n)))
main()
