from sys import stdin

a = stdin.readline()
a = a.upper()
z = len(a)
t = []

def pali(a,z,n):
    if n != z//2:
        if a[n]==a[-n-1]:
            t.append("yes")
        else:
            t.append("incorrect")
        pali(a,z,n+1)
def main():
    pali(a,z,0)
    if "incorrect" in t:
        print("Incorrecta")
    else:
        print("Correcta")
main()
