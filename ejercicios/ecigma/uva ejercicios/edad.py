from sys import stdin

def años (b, c, n):
    if b[1]>c[1]:
        n = b[2]-c[2]
    elif b[1]<c[1]:
        n = b[2]-c[2]-1
    elif b[1]==c[1]:
        if b[0]>=c[0]:
            n = b[2]-c[2]
        elif b[0]<=c[0]:
            n = b[2]-c[2]-1
    return n
def main():
    a = int(stdin.readline())
    for x in range(1,a+1):
        a = stdin.readline().strip()
        b = [int(s) for s in stdin.readline().strip().split("/")]
        c = [int(k) for k in stdin.readline().strip().split("/")]
        f = años(b,c,0)
        if f < 0:
            print("Case #"+str(x)+":", "Invalid birth date")
        elif f > 130:
            print("Case #"+str(x)+":", "Check birth date")
        else:
            print("Case #"+str(x)+":",f)
main()
            
            
