from sys import stdin

def main():
    t =int(stdin.readline())
    for cases in range(t):
        n=int(stdin.readline())
        acc=set(range(1,n+1))
        mat=[]
        acc_col=[set() for i in range(n)]
        trace=0
        n_row=0
        n_col=0
        for i in range(n):
            l=[int(x) for x in stdin.readline().strip().split()]
            mat.append(l)
            if(set(l)!=acc):
                n_row+=1
            for j in range(len(l)):
                acc_col[j].add(l[j])
            trace+=l[i]
        for i in acc_col:
            if i!=acc:
                n_col+=1
        print("Case #"+str(cases+1)+":",trace,n_row,n_col)
main()
