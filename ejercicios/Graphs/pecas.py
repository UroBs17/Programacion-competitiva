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
def kruskal(arcos,lista):
    un=DisjoinSet(len(lista))
    cost=0
    for i in range(len(arcos)):
        if un.Buscar(arcos[i][1])!=un.Buscar(arcos[i][2]):
            cost+=arcos[i][0]
            un.Union(arcos[i][1],arcos[i][2])
    print("%.2f"%(cost))
def main():
    n=int(stdin.readline())
    for h in range(n):
        blank=stdin.readline()
        nodos=int(stdin.readline())
        dic={}
        lista=[]
        for i in range(nodos):
            nodo=[float(x) for x in stdin.readline().strip().split()]
            dic[str(nodo)]=i
            lista.append(nodo)
        arcos=[]
        for i in range(len(lista)-1):
            x1,y1=lista[i][0],lista[i][1]
            for j in range(i+1,len(lista)):
                x2,y2=lista[j][0],lista[j][1]
                distancia=(((y2-y1)**2)+((x2-x1)**2))**(1/2)
                arcos.append([distancia,dic[str(lista[i])],dic[str(lista[j])]])
        arcos.sort()
        kruskal(arcos,lista)
        if h != n-1:
            print()
main()
