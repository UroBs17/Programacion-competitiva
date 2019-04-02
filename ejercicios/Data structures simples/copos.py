from sys import stdin

def solve(lista):
    cont=[[lista[0]]]
    maxi=1
    for i in range(1,len(lista)):
        if lista[i] not in cont[-1]:
            cont[-1].append(lista[i])
            maxi=max(maxi,len(cont[-1]))
        else:
            x=cont[-1].index(lista[i])
            lista1=cont[-1][x+1:]
            lista1+=[lista[i]]
            cont.append(lista1)
    print(maxi)
        
            
def main():
    cant=int(stdin.readline())
    for u in range(cant):
        lista=[]
        copos=int(stdin.readline())
        if copos==0:
            print(0)
        else:
            for k in range(copos):
                lista.append(int(stdin.readline()))
            solve(lista)
main()
