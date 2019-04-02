from sys import stdin
def dfs(u):
    global counter
    global mat
    global dfs_num
    global dfs_low
    global dfs_parent
    global vertex
    global root
    global child
    global n
    counter+=1
    dfs_num[u]=counter
    dfs_low[u]=counter
    for v in range(n):
        if mat[u][v]!=0:
            if dfs_num[v]==-1:
                dfs_parent[v]=u
                if u ==root:
                    child+=1
                dfs(v)
                if dfs_low[v]>=dfs_num[u]:
                    vertex[u]=True
                dfs_low[u]=min(dfs_low[u],dfs_low[v])
            elif v != dfs_parent[u]:
                dfs_low[u]=min(dfs_low[u],dfs_num[v])
                
def main():
    global counter
    global mat
    global dfs_num
    global dfs_low
    global dfs_parent
    global vertex
    global root
    global child
    global n
    c=1
    n=int(stdin.readline())
    while n:
        dic={}
        imp={}
        for nodo in range(n):
            x=stdin.readline().strip()
            dic[x]=nodo
            imp[nodo]=x
        mat=[[0 for i in range(n)] for j in range(n)]
        arcs=int(stdin.readline())
        for arc in range(arcs):
            p1,p2=stdin.readline().strip().split()
            mat[dic[p1]][dic[p2]]=1
            mat[dic[p2]][dic[p1]]=1
        counter=0
        dfs_num=[]
        dfs_low=[]
        dfs_parent=[]
        vertex=[]
        for i in range(n):
            dfs_num.append(-1)
            dfs_low.append(-1)
            dfs_parent.append(-1)
            vertex.append(False)
        for i in range(n):
            if dfs_num[i]==-1:
                root=i
                child=0
                dfs(i)
                vertex[root]=(child>1)
        listapendeja=[]
        for i in range(n):
            if vertex[i]:
                listapendeja.append(imp[i])
        listapendeja.sort()
        if c!=1:
            print()
        print("City map #"+str(c)+": "+str(len(listapendeja))+" camera(s) found")
        for x in listapendeja:
            print(x)
        c+=1
        n=int(stdin.readline())
main()
            
