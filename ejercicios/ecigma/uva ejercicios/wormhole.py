from sys import stdin

def bellman_ford(dic,src):
    dist={}
    padre={}
    for node in dic:
        dist[node]=2**31-1
        padre[node]=None
    dist[src]=0
    for i in range(len(dic)-1):
        for u in dic:
            for ele in dic[u]:
                v,p=ele
                if dist[v]>dist[u]+p:
                    dist[v]=dist[u]+p
                    padre[v]=u
    for u in dic:
        for v,p in dic[u]:
            if dist[v]>dist[u]+p:
                return True
    return False
    
def main():
    n= int(stdin.readline())
    for i in range(n):
        nodes,arcos=[int(x) for x in stdin.readline().strip().split()]
        dic={l:[] for l in range(nodes)}
        for i in range(arcos):
            x,y,p=[int(x) for x in stdin.readline().strip().split()]
            dic[x].append([y,p])
        x=bellman_ford(dic,0)
        if x:
            print("possible")
        else:
            print("not possible")
main()
