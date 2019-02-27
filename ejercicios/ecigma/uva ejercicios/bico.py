from sys import stdin
def solve(dic,n):
    q=[]
    q.append(0)
    color={}
    for i in range(n):
        color[i]=2
    color[0]=0
    while q:
        u = q.pop(0)
        if u in dic:
            for v in dic[u]:
                if color[v]==2:
                    color[v]=1-color[u]
                    q.append(v)
                elif color[v]==color[u]:
                    print("NOT BICOLORABLE.")
                    return
    print("BICOLORABLE.")
def main():
    n=int(stdin.readline())
    while n:
        arc=int(stdin.readline())
        dic={}
        for i in range(arc):
            ini,fin=[int(x) for x in stdin.readline().strip().split()]
            if ini in dic:
                dic[ini].append(fin)
            else:
                dic[ini]=[fin]
        solve(dic,n)
        n=int(stdin.readline())
main()
