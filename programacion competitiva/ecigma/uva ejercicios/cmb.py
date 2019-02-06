from sys import stdin

def solve(u):
    q=u//25
    resq=u%25
    d=resq//10
    resd=resq%10
    n=resd//5
    resn=resd%5
    p=resn
    return str(q),str(d),str(n),str(p)
def main():
    k=int(stdin.readline())
    for i in range(k):
        q,d,n,p=solve(int(stdin.readline()))
        print(i+1,q+" QUARTER(S), "+d+" DIME(S), "+n+" NICKEL(S), "+p+" PENNY(S)")
main()
        
        
    
