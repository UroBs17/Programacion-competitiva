from sys import stdin
class DisjoinSet(object):
    def __init__(self, n):
        self.padre = [x for x in range(n)]
        self.rank = [0 for x in range(n)]
        self.tam= [1 for x in range(n)]

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
            temp=self.tam[yRaiz]
            self.tam[yRaiz]+=self.tam[xRaiz]
            self.tam[xRaiz]+=temp
        elif self.rank[xRaiz] > self.rank[yRaiz]:
            self.padre[yRaiz] = xRaiz
            temp=self.tam[xRaiz]
            self.tam[xRaiz]+=self.tam[yRaiz]
            self.tam[yRaiz]+=temp
        else:
            self.padre[yRaiz] = xRaiz
            temp=self.tam[xRaiz]
            self.tam[xRaiz]+=self.tam[yRaiz]
            self.tam[yRaiz]+=temp
            self.rank[xRaiz]+=1
def main():
    n=int(stdin.readline())
    for i in range(n):
        n,m=[int(x) for x in stdin.readline().strip().split()]
        x=DisjoinSet(n)
        for j in range(m):
            k,l=[int(x)-1 for x in stdin.readline().strip().split()]
            if x.Buscar(k)!=x.Buscar(l):
                x.Union(k,l)
        print(max(x.tam))
main()
