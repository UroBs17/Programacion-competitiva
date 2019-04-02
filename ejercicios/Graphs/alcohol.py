from sys import stdin
def toposort(dic,orden):
    indice,bebidas=0,[]
    pred={i:0 for i in dic}
    for i in dic:
        for j in dic[i]:
            pred[j]+=1
    while indice<len(orden):
        ini=orden[indice]
        if not pred[ini]:
            orden.remove(ini)
            bebidas.append(ini)
            indice=-1
            for k in dic[ini]:
                pred[k]-=1
        indice+=1
    return bebidas
def main():
    nodos=stdin.readline().strip()
    c=1
    while len(nodos)!=0:
        nodos=int(nodos)
        dic={}
        orden=[]
        for i in range(nodos):
            bebida=stdin.readline().strip()
            orden.append(bebida)
            dic[bebida]=[]
        preorden=int(stdin.readline())
        for i in range(preorden):
            pre=stdin.readline().strip().split()
            dic[pre[0]].append(pre[1])
        sol=toposort(dic,orden)
        print('Case #'+str(c)+': Dilbert should drink beverages in this order: '+' '.join(sol)+'.')
        print()
        blank=stdin.readline().strip()
        nodos=stdin.readline().strip()
        c+=1
main()
