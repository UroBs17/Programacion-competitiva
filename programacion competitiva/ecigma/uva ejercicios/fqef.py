from sys import stdin
def lcs(mat,list1,list2):
    maxi=0
    for i in range(1,len(mat)):
        for j in range(1,len(mat[i])):
            if list1[i-1]==list2[j-1]:
                mat[i][j]=mat[i-1][j-1]+1
            else:
                mat[i][j]=max(mat[i][j-1],mat[i-1][j])
            maxi=max(mat[i][j],maxi)
    return maxi
def main():
    n,m=[int(x) for x in stdin.readline().strip().split()]
    cont=1
    while n!=0 and m!=0:
        list1=[int(x) for x in stdin.readline().strip().split()]
        list2=[int(x) for x in stdin.readline().strip().split()]
        mat=[[0 for j in range(m+1)] for i in range(n+1)]
        print("Twin Towers #"+str(cont))
        print("Number of Tiles :",lcs(mat,list1,list2))
        print()
        n,m=[int(x) for x in stdin.readline().strip().split()]
        cont+=1
main()
        
