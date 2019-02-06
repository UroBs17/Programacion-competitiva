from collections import defaultdict
from sys import stdin
def topoVisit(u):
    global graph
    global visited
    global result
    visited[u] = 1
    for v in graph[u]:
        if not visited[v]: 
            topoVisit(v)
    result.append(u)
def topoSort(nodes, graph):
    global visited
    global result
    visited = {}
    result = []
    for v in nodes:
        visited[v] = 0
    for v in nodes:
        if not visited[v]:
            topoVisit(v)
    result.reverse()
    print(' '.join([str(e) for e in result]))
def main():
    global graph
    global nodes
    n, m = [int(x) for x in stdin.readline().strip().split()]
    while n != 0 and m != 0:
        graph = defaultdict(list)
        nodes = list(range(1, n + 1))
        for i in range(m):
            v1, v2 = list(map(int, stdin.readline().strip().split()))
            graph[v1].append(v2)
        topoSort(nodes, graph)
        n, m = [int(x) for x in stdin.readline().strip().split()]
main()
