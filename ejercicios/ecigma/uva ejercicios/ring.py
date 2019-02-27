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
def comp(ele1,ele2):
    distancia=(((ele1[0]-ele2[0])**2)+((ele1[1]-ele2[1])**2))**(1/2)
    rmayor=max(ele1[2],ele2[2])
    rmenor=min(ele1[2],ele2[2])
    if rmayor>distancia:
        if distancia+rmenor>rmayor:
            return True
        else:
            return False
    else:
        if distancia>ele1[2]+ele2[2]:
            return False
        else:
            return True
def main():
    n=int(stdin.readline())
    while n!=-1:
        x=DisjoinSet(n)
        mat=[]
        dic={}
        for i in range(n):
            nodo=[float(h) for h in stdin.readline().strip().split()]
            mat.append(nodo)
            dic[" ".join(list(map(str,nodo)))]=i
        for k in range(n-1):
            for j in range(k+1,n):
                d=comp(mat[k],mat[j])
                if d:
                    if x.Buscar(dic[" ".join(list(map(str,mat[k])))])!=x.Buscar(dic[" ".join(list(map(str,mat[j])))]):
                        x.Union(dic[" ".join(list(map(str,mat[k])))],dic[" ".join(list(map(str,mat[j])))])
        u=max(x.tam)
        if u==1:
            print("The largest component contains 1 ring.")

        else:
            print("The largest component contains "+str(u)+" rings.")
        n=int(stdin.readline())
main()
