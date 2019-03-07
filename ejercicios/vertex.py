from sys import stdin
def dfs(root):
    global dic
    global visited
    global nodes
    for node in dic[root]:
        if not visited[node]:
            visited[node]=True
            nodes.add(node)
            dfs(node)
    return nodes
def main():
    global dic
    global visited
    global nodes
    n=int(stdin.readline())
    while n!=0:
        lista=[int(x) for x in stdin.readline().strip().split()]
        dic={}
        sett=set()
        for i in range(1,n+1):
            dic[i]=[]
            sett.add(i)
        
        while lista[0]!=0:
            dic[lista[0]]+=lista[1:-1]
            lista=[int(x) for x in stdin.readline().strip().split()]
        query=[int(x) for x in stdin.readline().strip().split()]
        for i in range(1,len(query)):
            nodes=set()
            visited=[False]*(n+1)
            sett1=dfs(query[i])
            rta=sett-sett1
            rta=list(rta)
            rta.sort()
            if len(rta)>0:
                print(str(len(rta))+" "+" ".join(list(map(str,rta))))
            else:
                print(0)
        n=int(stdin.readline())
main()
