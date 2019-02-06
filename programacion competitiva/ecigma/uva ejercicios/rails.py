from sys import stdin
def solve(listaSal,n):
    pivote=[0]
    listaIn=list(set(range(1,n+1)))
    x=0
    while len(listaIn)!=0:
        pivote.append(listaIn[0])
        while x!=n:
            if pivote[-1]==listaSal[x]:
                del pivote[-1]
                x+=1
            else:
                break
        del listaIn[0]
    if len(pivote)>1:
        print("No")
    else:
        print("Yes")
def main():
    n=int(stdin.readline())
    while n!=0:
        listaSal=[int(x) for x in stdin.readline().strip().split()]
        while listaSal[0]!=0:
            solve(listaSal,n)
            listaSal=[int(x) for x in stdin.readline().strip().split()]
        print()
        n=int(stdin.readline())
main()
        
            
        
        
