from sys import stdin
from collections import defaultdict
def dfs(node):
    global ans
    global vis
    global graph
    vis[node]=True
    for x in range(len(graph[node])):
        if not vis[graph[node][x]]:
            dfs(graph[node][x])
    ans.append(node)
def main():
    global ans
    global vis
    global graph
    n,m=[int(x) for x in stdin.readline().strip().split()]
    while n!=0 and m!=0:
        graph=[]
        vis=[]
        ans=[]
        for x in range(n):
            graph.append([])
            vis.append(False)
        for i in range(m):
            v1,v2=[int(x) for x in stdin.readline().strip().split()]
            graph[v1-1].append(v2-1)
        for node in range(len(graph)):
            if not vis[node]:
                dfs(node)
        ans=ans[::-1]
        ans=[str(x+1) for x in ans]
        print(" ".join(ans))
        n,m=[int(x) for x in stdin.readline().strip().split()]
main()
