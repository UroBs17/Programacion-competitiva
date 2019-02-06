from sys import stdin
from collections import deque
def main():
    n=int(stdin.readline())
    c=1
    while n:
        print("Scenario #"+str(c))
        c+=1
        grupos={}
        grupo=[]
        fila=deque()
        for i in range(n):
            amigos=list(map(int,stdin.readline().strip().split()))
            grupo.append(deque())
            for j in amigos[1:]:
                grupos[j]=i
        comando=stdin.readline().strip().split()
        while comando[0] != "STOP":
            if comando[0] == "ENQUEUE":
                persona=int(comando[1])
                t=grupos[persona]
                grupo[t].append(persona)
                if len(grupo[t])==1:
                    fila.append(grupo[t])
            else:
                grcabeza=fila.popleft()
                cabeza=grcabeza.popleft()
                print(cabeza)
                if grcabeza:
                    fila.appendleft(grcabeza)
            comando=stdin.readline().strip().split()
        print()
        n=int(stdin.readline())
main()
