from sys import stdin
def f1(arr):
    rta=[1]*(len(arr))
    for i in range(len(arr)-1,-1,-1):
        for j in range(i+1,len(arr)):
            if arr[i]>arr[j]:
                rta[i]=max(rta[j]+1,rta[i])
    return rta
def f2(arr):
    rta=[1]*(len(arr))
    for i in range(len(arr)-1,-1,-1):
        for j in range(i+1,len(arr)):
            if arr[i]<arr[j]:
                rta[i]=max(rta[j]+1,rta[i])
    return rta
def main():
    casos=int(stdin.readline().strip())
    for i in range(casos):
        lonTren=int(stdin.readline().strip())
        if lonTren == 0:
            print(0)
        else:
            y=[]
            for j in range(lonTren):
                y.append(int(stdin.readline().strip()))
            u=f1(y)
            v=f2(y)
            x=0
            for i in range(lonTren):
                x=max(x,u[i]+v[i]-1)
            print(x)
main()
