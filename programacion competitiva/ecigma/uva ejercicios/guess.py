from sys import stdin
from collections import deque
def main():
    n=stdin.readline().strip()
    while n:
        n=int(n)
        confirmacion=[True,True,True]
        g=["stack","queue","priority queue"]
        arr,queue,heapq=[],deque(),[]
        verificacion=True
        for i in range(n):
            pro,x=[int(j) for j in stdin.readline().strip().split()]
            if i==0 and pro==2:
                print("impossible")
                verificacion=False
            if pro==1:
                arr.append(x)
                queue.append(x)
                heapq.append(x)
            if x not in arr and x not in queue and x not in heapq:
                confirmacion=[False,False,False]
            elif pro==2 and len(arr)>0 and len(queue)>0 and len(heapq)>0:
                d=max(heapq)
                ind=heapq.index(d)
                k,l,m=arr.pop(),queue.popleft(),d
                if k!=x:
                    confirmacion[0]=False
                if l!=x:
                    confirmacion[1]=False
                if m!=x:
                    confirmacion[2]=False
                if m==x:
                    del heapq[ind]
        if verificacion:
            ver=confirmacion.count(True)
            if ver==0:
                print("impossible")
            elif ver==1:
                f=confirmacion.index(True)
                print(g[f])
            else:
                print("not sure")
        n=stdin.readline().strip()
main()
