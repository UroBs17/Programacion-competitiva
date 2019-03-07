from sys import stdin
fil=[0,0,1,-1]
col=[-1,1,0,0]
def flodfill(i,j,letra):
    global mat
    global fil
    global col
    if i<0 or i>=len(mat) or j<0 or j>=len(mat):
        return 
    if mat[i][j]!=letra or mat[i][j]!=0:
        return 
    mat[i][j]=0
    for g in range(4):
        flodfill(i+fil[g],j+col[g],mat)
    return 
def main():
    global mat
    n=int(stdin.readline())
    for k in range(n):
        n,m=[int(x) for x in stdin.readline().strip().split()]
        mat=[]
        for i in range(n):
            mat.append(list(stdin.readline().strip()))
        dic={}
        for i in range(n):
            for j in range(m):
                if mat[i][j]!=0:
                    flodfill(i,j,mat[i][j])
                    if mat[i][j] not in dic:
                        dic[mat[i][j]]=0
                    else:
                        dic[mat[i][j]]+=1
        for ele in mat:
            print(ele)
        print(dic)
        print("--------")
main()
                    
                    
