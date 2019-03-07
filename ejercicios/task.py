from collections import deque
from sys import stdin
def kahn_topsort(graph):
    in_degree = { u : 0 for u in graph }     
    for u in graph:                          
        for v in graph[u]:
            in_degree[v] += 1
 
    Q = deque() 
    for u in in_degree:
        if in_degree[u] == 0:
            Q.appendleft(u)
 
    L = []
     
    while Q:                
        u = Q.pop() 
        L.append(u) 
        for v in graph[u]:
            in_degree[v] -= 1
            if in_degree[v] == 0:
                Q.appendleft(v)
 
    if len(L) == len(graph):
        return L
    else:           
        return []
def main():
    n,m=[int(x) for x in stdin.readline().strip().split()]
    while n!=0 and m!=0:
        dic={u:[] for u in range(1,n+1)}
        for j in range(m):
            p,q=[int(x) for x in stdin.readline().strip().split()]
            dic[p].append(q)
        print(" ".join(list(map(str,kahn_topsort(dic)))))
        n,m=[int(x) for x in stdin.readline().strip().split()]
main()
