a = int(input("#"))
k = len(str(a))
x=[]
def num (a, k):
    if k>0:
        l= a//(10**k)
        m= a%(10**k)
        num(m,k-1)
        x.append(l)
    if k==0:
        z= (a%10)
        x.append(z)
    return max(x)*(k+1)
def main():
    f= num(a,k-1)
    print(max(x),"x",k,"=",f)
main()
