from sys import stdin

a = int(stdin.readline())
k = len(str(a))
x = []

def num (l, d):
    if d>0:
        s = (l//(10**d))
        f = (l%(10**d))
        x.append(s)
        num(f,d-1)
    if d==0:
        j=l%10
        x.append(j)
    return x

def may(x, k):
    if 0 < k:
        if  x[0] >=  x[1]:
            x.remove(x[1])
        elif x[0] <= x[1]:
            x.remove(x[0])
        may(x, k-1)
    elif len(x)== 1:
        print(x[0])    
        
def main():
    may(num(a,k-1), k-1)
    
main()
