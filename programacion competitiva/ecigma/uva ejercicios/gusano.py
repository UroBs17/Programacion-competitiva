from sys import stdin
def initialize(n, source):
    d = {} 
    for node in range(n):
        d[node] = float('Inf') 
    d[source] = 0 
    return d

def bellman_ford(graph, source,n):
    d = initialize(n, source)
    for i in range(n-1): 
        for u in graph:
            for v in graph[u]:
                d[v] = min(d[v] ,d[u] + graph[u][v])
    x=False
    for u in graph:
        for v in graph[u]:
            if d[v] < d[u] + graph[u][v]:
                x=True
    return x
def main():
    n=int(stdin.readline())
    for i in range(n):
        nodos,arcos=[int(x) for x in stdin.readline().strip().split()]
        dic={}
        for h in range(arcos):
            i,j,arco=[int(x) for x in stdin.readline().strip().split()]
            if i in dic:
                dic[i][j]=arco
            else:
                dic[i]={j:arco}
        if bellman_ford(dic, 0,nodos):
            print("possible")
        else:
            print("not possible")
main()
