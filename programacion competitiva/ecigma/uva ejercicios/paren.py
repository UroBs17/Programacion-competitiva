from sys import stdin
def solve(pala):
    pila=[]
    for i in range(len(pala)):
        if pala[i]=="(":
            pila.append("(")
        elif pala[i]=="[":
            pila.append("[")
        elif pala[i]=="]":
            if len(pila)>0 and pila[-1]=="[":
                del pila[-1]
            else:
                return False
        elif pala[i]==")":
            if len(pila)>0 and pila[-1]=="(":
                del pila[-1]
            else:
                return False
    if len(pila)>0:
        return False
    else:
        return True
def main():
    n=int(stdin.readline())
    for i in range(n):
        string=stdin.readline().strip()
        x=solve(string)
        if x:
            print("Yes")
        else:
            print("No")
main()
