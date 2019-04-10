from sys import stdin
def solve():
    n=[0,1,2,2,4,4,6,6,10,10]
    for i in range(10,1001):
        if i%2==0:
            x=n[i//2]+n[i-1]
            n.append(x)
        else:
            n.append(n[i-1])
    return n
def main():
    t=int(stdin.readline())
    f=solve()
    for j in range(t):
        k=int(stdin.readline())
        print(j+1,f[k])
main()
        
