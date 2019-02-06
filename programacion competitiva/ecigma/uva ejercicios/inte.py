from sys import stdin

a = float(stdin.readline())
i = float(stdin.readline())
d = float(stdin.readline())

def inte(a, i, d):
    if d > 1:
        return inte(a,i,d-1)*(1+i)
    elif d==1:
        return a*(1+i)
def main():
    print("$"+str(round(inte(a, i, d),1)))
main()
        
