from sys import stdin
dic={}
def pali(pala,i,j):
    global dic
    if pala+str(i)+"-"+str(j) in dic:
        return dic[pala+str(i)+"-"+str(j)]
    if i==j:
        return 1
    if i==j-1:
        if pala[i]==pala[j]:
            return 2
        else:
            return 1
    if i>j:
        return 0
    if pala[i]==pala[j]:
        return pali(pala,i+1,j-1)+2
    else:
        dic[pala+str(i)+"-"+str(j)]=max(pali(pala,i,j-1),pali(pala,i+1,j))
        return dic[pala+str(i)+"-"+str(j)]
def main():
    casos=int(stdin.readline().strip())
    for i in range(casos):
        pala=stdin.readline().strip()
        if len(pala)==0:
            print(0)
        elif pala==pala[::-1]:
            print(len(pala))
        else:
            print(pali(pala,0,len(pala)-1))
main()
