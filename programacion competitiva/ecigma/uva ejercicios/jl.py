from sys import stdin
def main():
    h,r=[int(x) for x in stdin.readline().strip().split()]
    while h and r:
        vi=[0]*h
        for i in range(r):
            a,b=[int(x) for x in stdin.readline().strip().split()]
            vi[a-1]+=1
            vi[b-1]+=1
            print(vi)
        vi.sort()
        vi=vi[::-1]
        n=0
        for m in range(h):
            if vi[m]>=m:
                n+=1
        s=sum(vi[:n])
        ind=sum(vi[n:])
        if n*(n-1)+ind==s:
            print("Y")
        else:
            print("N")
        h,r=[int(x) for x in stdin.readline().strip().split()]
main()
