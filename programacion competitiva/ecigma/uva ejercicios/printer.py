from sys import stdin
def solve(arr,n,m):
    minutos=0
    while len(arr)>0:
        if m==0 and arr[0]==max(arr):
            minutos+=1
            break
        elif m==0 and arr[0]!=max(arr):
            m=len(arr)-1
            arr.append(arr[0])
            del arr[0]
        elif m!=0 and arr[0]==max(arr):
            del arr[0]
            m-=1
            minutos+=1
        elif m!=0 and arr[0]!=max(arr):
            m-=1
            arr.append(arr[0])
            del arr[0]
    print(minutos)
def main():
    n=int(stdin.readline())
    for i in range(n):
        n,m=[int(x) for x in stdin.readline().strip().split()]
        arr=[int(x) for x in stdin.readline().strip().split()]
        solve(arr,n,m)
main()
"""

            print("arr",arr,"len(arr)",len(arr),"m",m,"minutos",minutos,"primer if")
            print("arr",arr,"len(arr)",len(arr),"m",m,"minutos",minutos,"segundo if")
            print("arr",arr,"len(arr)",len(arr),"m",m,"minutos",minutos,"tercer if")
            print("arr",arr,"len(arr)",len(arr),"m",m,"minutos",minutos,"cuarto if")
"""
