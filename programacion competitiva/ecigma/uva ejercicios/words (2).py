from sys import stdin
from collections import deque
from collections import defaultdict
def esAdy(pala1, pala2):
    c=0
    if len(pala1)!=len(pala2):
        return False
    for i in range(len(pala1)):
        if pala1[i]!=pala2[i]:
            c+=1
        if c>1:
            return False
    return True
def main():
    global adyacentes
    n=int(stdin.readline())
    blank=stdin.readline()
    for i in range(n):
        palabras=defaultdict(list)
        l=stdin.readline().strip()
        while l!="*":
            palabras[len(l)].append(l)
            l=stdin.readline().strip()
        query=stdin.readline().strip().split()
        while len(query)!=0:
            start,end=query[0],query[1]
            q=deque()
            dic={}
            dic[start]=0
            q.append(start)
            while q and end not in dic:
                u=q.popleft()
                for ele in palabras[len(start)]:
                    v=ele
                    if v not in dic and esAdy(u,v):
                        dic[v]=dic[u]+1
                        q.append(v)
            print(start+" "+end+" "+str(dic[end]))
            query=stdin.readline().strip().split()
        if i!=n-1:
            print()
main()
