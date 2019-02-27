from sys import stdin
def solve(num):
    denomi=[5,10,20,50,100,200,500,1000,2000,5000,10000]
    lista=[1]*(num+1)
    for i in range(11):
        for j in range(denomi[i],num+1):
            lista[j]+=lista[j-denomi[i]]
    return lista
def main():
    n=stdin.readline().strip()
    rta=solve(30010)
    while len(n) != 0:
        x=int(n)
        y=rta[x]
        print(y)
        n=stdin.readline().strip()
main()
