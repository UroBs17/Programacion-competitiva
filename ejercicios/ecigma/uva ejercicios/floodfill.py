from sys import stdin
fil=[-1,0,0,1]
col=[0,-1,1,0]
def flodfill(i,j,color,pared):
    global fil
    global col
    global mat
    if i<0 or i>=len(mat) or j<0 or j>=len(mat[i]):
        return
    if mat[i][j]==pared or mat[i][j]==color:
        return
    mat[i][j]=color
    for g in range(4):
        flodfill(i+fil[g],j+col[g],color,pared)
    return
def romper(mat):
    for i in range(len(mat)):
        for j in range(len(mat[i])):
            if mat[i][j]!=" ":
                return mat[i][j]
def main():
    global mat
    linea=stdin.readlines()
    mat=[]
    for x in linea:
        mat.append(list(x[:-1]))
        if len(x)>0 and x[0]=="_":
            u=mat.pop()
            pared=romper(mat)
            for i in range(len(mat)):
                for j in range(len(mat[i])):
                    if mat[i][j]!=" " and mat[i][j]!=pared:
                        color= mat[i][j]
                        mat[i][j]=" "
                        flodfill(i,j,color,pared)
            mat.append(u)
            for i in mat:
                print("".join(i))
            mat=[]
main()
