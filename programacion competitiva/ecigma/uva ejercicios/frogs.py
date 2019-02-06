from sys import stdin
def main():
    n=int(stdin.readline())
    c=1
    while n:
        lista=[]
        for i in range(n):
            cad=[int(x) for x in stdin.readline().strip().split()]
            lista.append(cad)
        mat=[[0 for x in range(n)]for h in range(n)]
        for i in range(len(lista)-1):
            x1,y1=lista[i][0],lista[i][1]
            for j in range(i+1,len(lista)):
                x2,y2=lista[j][0],lista[j][1]
                distancia=(((y2-y1)**2)+((x2-x1)**2))**(1/2)
                mat[i][j]=distancia
                mat[j][i]=distancia
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    mat[i][j]=min(mat[i][j],max(mat[i][k],mat[k][j]))
        print("Scenario #"+str(c))
        print("Frog Distance = %.3f"%(mat[0][1]))
        print()
        c+=1
        blank=stdin.readline()
        n=int(stdin.readline())
main()
