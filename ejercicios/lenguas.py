from sys import stdin
fil=[-1,0,0,1]
col=[0,-1,1,0]
def flodfill(i,j,letra):
    global fil
    global col
    global mat
    if i<0 or i>=len(mat) or j<0 or j>=len(mat[i]):
        return
    if mat[i][j]!=letra:
        return
    mat[i][j]="*"
    for g in range(4):
        flodfill(i+fil[g],j+col[g],letra)
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
                if mat[i][j]!="*":
                    char=mat[i][j]
                    flodfill(i,j,char)
                    if char in dic:
                        dic[char]+=1
                    else:
                        dic[char]=1
        lista=[]
        dic1={}
        for ele in dic:
            lista.append([dic[ele],ele])
            if dic[ele] in dic1:
                dic1[dic[ele]]+=1
            else:
                dic1[dic[ele]]=1
        lista.sort(reverse=True)
        h=0
        while h!=len(lista):
            salto=dic1[lista[h][0]]
            x=lista[h:h+salto]
            x.reverse()
            lista=lista[:h]+x+lista[h+salto:]
            h+=salto
        print("World #"+str(k+1))
        for u in lista:
            print(u[1]+": "+str(u[0]))
main()
