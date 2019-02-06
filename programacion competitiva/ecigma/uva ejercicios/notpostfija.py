from sys import stdin
def solve(lista):
    pila=[]
    for i in range(len(lista)):
        if lista[i]=="/":
            if pila[-1]==0:
                print("Error")
                return
            else:
                x=pila.pop()
                y=pila.pop()
                pila.append(y/x)
        elif lista[i]=="*":
            x=pila.pop()
            y=pila.pop()
            pila.append(y*x)
        elif lista[i]=="+":
            x=pila.pop()
            y=pila.pop()
            pila.append(y+x)
        elif lista[i]=="-":
            x=pila.pop()
            y=pila.pop()
            pila.append(y-x)
        else:
            pila.append(int(lista[i]))
    print("%.3f"%pila[0])
def main():
    exp=stdin.readline().strip().split()
    while len(exp)!=0:
        x=solve(exp)
        exp=stdin.readline().strip().split()
main()
