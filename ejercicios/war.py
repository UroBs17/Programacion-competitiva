from sys import stdin
fil=[-1,-1,-1,0,0,1,1,1]
col=[-1,0,1,-1,1,-1,0,1]
def flodfill(i,j,mat):
    global fil
    global col
    if i<0 or i>=len(mat) or j<0 or j>=len(mat):
        return 0
    if mat[i][j]!=1:
        return 0
    mat[i][j]=0
    for g in range(8):
        flodfill(i+fil[g],j+col[g],mat)
    return
def main():
    n=stdin.readline().strip()
    f=1
    while n:
        k=int(n)
        mat=[]
        h=0
        for cont in range(k):
            mat.append(list(map(int,list(stdin.readline().strip()))))
        for i in range(k):
            for j in range(k):
                if mat[i][j]==1:
                    flodfill(i,j,mat)
                    h+=1
        print("Image number "+str(f)+" contains "+str(h)+" war eagles.")
        f+=1
        n=stdin.readline().strip()
main()
