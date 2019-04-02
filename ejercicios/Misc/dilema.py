from sys import stdin

def main():
    n=int(stdin.readline())
    for k in range(n):
        rows,cols=[int(x) for x in stdin.readline().strip().split()]
        matriz=[]
        for h in range(rows):
            matriz.append(stdin.readline().strip().split())
        mat=[[matriz[j][i] for j in range(rows)] for i in range(cols)]
        cmf=True
        for x in matriz:
            if matriz.count("0")==cols:
                cmf=False
                break
        for ele in mat:
            if mat.count(ele)!=1:
                cmf=False
                break
            if ele.count("1")!=2:
                cmf=False
                break
        if cmf:
            print("Yes")
        else:
            print("No")
main()
