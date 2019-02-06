from sys import stdin
def main():
    casos = int(stdin.readline())
    for i in range(casos):
        tam, k = stdin.readline().strip().split()
        lista= stdin.readline().strip().split()
        n = 0
        for i in range(len(lista)-1):
            for j in range(i+1, len(lista)):
                if abs(int(lista[i])-int(lista[j]))==int(k):
                    n+=1
        print(n)
main()
        
