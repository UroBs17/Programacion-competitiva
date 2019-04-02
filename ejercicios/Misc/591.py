from sys import stdin

def main():
    t=1
    while True:
        n=int(stdin.readline())
        if n==0:break
        l=[int(x) for x in stdin.readline().strip().split()]
        l.sort()
        p=sum(l)/n
        k=0
        i=0
        while l[i]<p:
            k+=abs(p-l[i])
            i+=1
        print("Set #"+str(t))
        t+=1
        k=int(k)
        print("The minimum number of moves is "+str(k)+".")
        print()
main()
