from sys import stdin
def pali(pala):
    y=[]
    for i in range(len(pala)):
        x=[]
        for j in range(len(pala)):
            if i==j:
                x.append(1)
            else:
                x.append(0)
        y.append(x)
    for contador in range(1,len(pala)):
        for i in range(len(pala)-contador):
            j=contador+i
            if pala[i]==pala[j]:
                y[i][j]=2+y[i+1][j-1]
            else:
                y[i][j]=max(y[i][j-1],y[i+1][j])
    return y[0][len(pala)-1]
def main():
    casos=int(stdin.readline().strip())
    for i in range(casos):
        pala=stdin.readline().strip()
        if len(pala)==0:
            print(0)
        elif pala==pala[::-1]:
            print(len(pala))
        else:
            t= pali(pala)
            print(t)
main()
