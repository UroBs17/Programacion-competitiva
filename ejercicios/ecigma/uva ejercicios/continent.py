from sys import stdin
fil=[-1,0,0,1]
col=[0,-1,1,0]
def flodfill(i,j,mat,tierra):
    global fil
    global col
    if i<0 or i>=len(mat) or j<0 or j>=len(mat[0]):
        return 0
    if mat[i][j]!=tierra:
        return 0
    mat[i][j]="*"
    n=1
    for g in range(4):
        n+=flodfill(i+fil[g],j+col[g],mat,tierra)
    if j==0:
        n+=flodfill(i,len(mat[0])-1,mat,tierra)
    elif j==len(mat[0])-1:
        n+=flodfill(i,0,mat,tierra)
    return n
def main():
    linea=stdin.readline().strip().split()
    while linea:
        n=int(linea[0])
        m=int(linea[1])
        mat=[]
        for elem in range(n):
            mat.append(list(stdin.readline().strip()))
        x,y=[int(x) for x in stdin.readline().strip().split()]
        tierra=mat[x][y]
        flodfill(x,y,mat,tierra)
        k=0
        for i in range(n):
            for j in range(m):
                if mat[i][j]==tierra:
                    r=flodfill(i,j,mat,tierra)
                    k=max(k,r)
        print(k)
        blank=stdin.readline()
        linea=stdin.readline().strip().split()
main()
    
