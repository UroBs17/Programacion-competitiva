from sys import stdin
def main():
    n=int(stdin.readline())
    while n:
        dic={}
        for i in range(n):
            t=[int(x) for x in stdin.readline().strip().split()]
            t.sort()
            if str(t) in dic:
                dic[str(t)]+=1
            else:
                dic[str(t)]=1
        x=list(dic.values())
        d=max(x)
        e=x.count(d)
        print(e*d)
        n=int(stdin.readline())
main()
