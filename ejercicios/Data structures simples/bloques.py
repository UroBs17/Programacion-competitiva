from sys import stdin
pos={}
blo={}
def posini(bloque,num):
    while bloque[-1]!=num:
        pos[bloque[-1]]=bloque[-1]
        blo[bloque[-1]].append(bloque[-1])
        bloque.pop()
def main():
    n=int(stdin.readline())
    for i in range(n):
        pos[i]=i
        blo[i]=[i]
    comando=stdin.readline().strip().split()
    while comando[0]!="quit":
        if int(comando[1]) != int(comando[3]) and pos[int(comando[1])]!=pos[int(comando[3])]:
            if comando[0]=="move":
                if comando[2]=="onto":
                    posini(blo[pos[int(comando[1])]],int(comando[1]))
                    posini(blo[pos[int(comando[3])]],int(comando[3]))
                    blo[pos[int(comando[3])]].append(blo[pos[int(comando[1])]].pop())
                    pos[int(comando[1])]=pos[int(comando[3])]
                elif comando[2]=="over":
                    posini(blo[pos[int(comando[1])]],int(comando[1]))
                    blo[pos[int(comando[3])]].append(int(comando[1]))
                    blo[pos[int(comando[1])]].pop()
                    pos[int(comando[1])]=pos[int(comando[3])]
            elif comando[0]=="pile":
                if comando[2]=="onto":
                    posini(blo[pos[int(comando[3])]],int(comando[3]))
                    blo[pos[int(comando[3])]]+=blo[pos[int(comando[1])]][blo[pos[int(comando[1])]].index(int(comando[1])):]
                    del blo[pos[int(comando[1])]][blo[pos[int(comando[1])]].index(int(comando[1])):]
                    for i in blo[pos[int(comando[3])]][blo[pos[int(comando[3])]].index(int(comando[1])):]:
                        pos[i]=pos[int(comando[3])]
                elif comando[2]=="over":
                    blo[pos[int(comando[3])]]+=blo[pos[int(comando[1])]][blo[pos[int(comando[1])]].index(int(comando[1])):]
                    del blo[pos[int(comando[1])]][blo[pos[int(comando[1])]].index(int(comando[1])):]
                    for i in blo[pos[int(comando[3])]][blo[pos[int(comando[3])]].index(int(comando[1])):]:
                        pos[i]=pos[int(comando[3])]
        comando=stdin.readline().strip().split()
    for i in blo:
        if len(blo[i])==0:
            print(str(i)+":")
        else:
            print(str(i)+":", " ".join(list(map(str,blo[i]))))
main()
