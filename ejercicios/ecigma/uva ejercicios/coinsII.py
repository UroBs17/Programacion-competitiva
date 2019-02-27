from sys import stdin


def main():
    casos=int(stdin.readline())
    maxi=2147483647
    for i in range(casos):
        item=int(stdin.readline())
        deno=int(stdin.readline())
        monedo=[int(stdin.readline()) for i in range(deno)]
        cambio=[maxi for i in range(10001)]
        cambio[0]=0
        for i in range(deno):
            for j in range(10000,0,-1):
                if j-monedo[i]>=0 and cambio[j-monedo[i]]+1<cambio[j]:
                    cambio[j]=cambio[j-monedo[i]]+1
        for x in range(item,10001):
            if cambio[x]!=maxi:
                print(x,cambio[x])
                break
main()
