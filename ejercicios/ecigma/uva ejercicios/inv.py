from sys import stdin

a = int(stdin.readline())
z = len(str(a))
t = []

def num (l, d):
    if d>0:
        s = (l//(10**d))
        f = (l%(10**d))
        num(f,d-1)
        t.append(str(s))
    if d==0:
        j=l%10
        t.append(str(j))
    return t

def main():
    d = num(a,z-1)
    cadena="".join(d)
    print(cadena)
main()
