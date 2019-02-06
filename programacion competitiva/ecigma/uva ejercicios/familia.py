from sys import stdin

a = int(stdin.readline())
b = int(stdin.readline())
l = len(str(b))
k = len(str(a))

def num (l, d, x):
    if d>0:
        s = (l//(10**d))
        f = (l%(10**d))
        x.append(s)
        num(f,d-1,x)
    if d==0:
        j=l%10
        x.append(j)
    return x

def suma(x, k, n):
    if n < k:
        c = x[n] + x[n+1]
        x[n:n+2] = [c]
        suma(x, k-1, n)
        return x[0]
    else:
        return x[0]
    
def main():
    if (suma(num(a, k-1, []), k-1, 0)) == (suma(num(b, l-1, []), l-1, 0)) :
        print(a,"y",b,"si son familia")
    else:
        print(a,"y",b,"no son familia")
    
main()
