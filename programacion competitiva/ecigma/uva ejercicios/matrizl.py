from sys import stdin
def cadena(a):
    a = str(a)
    a = a.split()
    k = ""
    for i in range(len(a)):
        k = k+str(a[i])
    print(k)
    return k
def inicial(n,s):
    for i in range(n):
        s.append(1)
    return s
def matriz(k,n):
    i = n
    while i != len(k)-n+1:
        k[i] = n
        i += 1
    return k
def main():
    n = int(stdin.readline())
    h = []
    z = inicial(n, [])
    cadena(z)
    h.insert(0,z)
    for i in range(2,n+1):
        z = matriz(z,i)
        h.insert(0, cadena(z))
    print(h)
main()
