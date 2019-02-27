from sys import stdin

def main():
    a,b=[int(x) for x in stdin.readline().strip().split()]
    lista=[]
    for i in range(a):
        lista.append([int(x) for x in list(stdin.readline().strip())])
    v=True
    for i in range(a):
        ant=lista[i][0]
        for j in range(b):
            v= v and ant==lista[i][j]

        if v:
            if i>0:
                v=v and lista[i-1][0]!=lista[i][0]
        else:
            break
    if v:
        print("YES")
    else:
        print("NO")
main()
