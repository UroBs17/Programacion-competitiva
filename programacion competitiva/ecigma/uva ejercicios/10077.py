from sys import stdin
def f(l1,l2,r1,r2,d1,d2,rta):
    m1,m2=l1+r1,l2+r2
    if m1==d1 and m2==d2:
        print(rta)
        return 
    if m1/m2<d1/d2:
        f(m1,m2,r1,r2,d1,d2,rta+"R")
    if m1/m2>d1/d2:
        f(l1,l2,m1,m2,d1,d2,rta+"L")
    return
def main():
    d1,d2=[int(x) for x in stdin.readline().strip().split()]
    while d1!=1 and d2!=1:
        f(0,1,1,0,d1,d2,"")
        d1,d2=[int(x) for x in stdin.readline().strip().split()]
main()
