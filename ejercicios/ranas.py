from sys import stdin

def main():
    n=int(stdin.readline())
    f=1
    while n:
        piedras=[]
        for i in range(n):
            x,y=[float(u) for u in stdin.readline().strip().split()]
            piedras.append([x,y])
        dijk=[]
        for i in range(n):
            dijk.append([2**31-1,0])
        dijk[0][1]=1
        maxi=0
        temp=1
        now=0
        while now !=1:
            temp=1
            for i in range(n):
                if dijk[i][1]==0:
                    dijk[i][0]=min(dijk[i][0],(((piedras[now][0]-piedras[i][0])**2)+((piedras[now][1]-piedras[i][1])**2))**(1/2))
                    if dijk[i][0]<dijk[temp][0]:
                        temp=i
            now=temp
            maxi=max(maxi,dijk[now][0])
            dijk[now][1]=1
        stdin.readline()
        print("Scenario #"+str(f))
        print("Frog Distance = %.3f"%maxi)
        print()
        f+=1
        n=int(stdin.readline())
main()
