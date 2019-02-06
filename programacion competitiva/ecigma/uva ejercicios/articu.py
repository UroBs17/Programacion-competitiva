from sys import stdin
def point(u,low,num,count,mat,pat,root,child,n):
    global vertex
    global listapendeja
    listapendeja= vertex.copy()
    count+=1
    low[u]=count
    num[u]=count
    for v in range(n):
        if mat[u][v] != 0:
            if num[v]==-1:
                pat[v]=u
                if u==root:
                    child+=1
                point(v,low,num,count,mat,pat,root,child,n)
                if low[v]>=num[u]:
                    vertex[u]=True
                low[u]=min(low[u],low[v])
            elif v != pat[u]:
                low[u]=min(low[u],num[v])
def main():
    global vertex
    global listapendeja
    n=int(stdin.readline())
    cont=1
    while n:
        nodos={}
        imp={}
        for g in range(n):
            x=stdin.readline().strip()
            nodos[x]=g
            imp[g]=x
        mat=[[0 for i in range(n)] for j in range(n)]
        conexiones=int(stdin.readline())
        for h in range(conexiones):
            p1,p2=stdin.readline().strip().split()
            mat[nodos[p1]][nodos[p2]]=1
            mat[nodos[p2]][nodos[p1]]=1
        count=0
        num=[]
        low=[]
        pat=[]
        vertex=[]
        for t in range(n):
            num.append(-1)
            low.append(-1)
            pat.append(-1)
            vertex.append(False)
        for i in range(n):
            if num[i]==-1:
                root=i
                child=0
                point(i,low,num,count,mat,pat,root,child,n)
                vertex[root]=(child>1)
        print(imp)
        print(listapendeja)
        listapendejax2=[]
        for i in range(n):
            if listapendeja[i]:
                listapendejax2.append(imp[i])
        listapendejax2.sort()
        print("City map #"+str(cont)+": "+str(len(listapendejax2))+"camera(s) found")
        for ele in listapendejax2:
            print(ele)
        print()
        cont+=1
        n=int(stdin.readline())
        
main()
