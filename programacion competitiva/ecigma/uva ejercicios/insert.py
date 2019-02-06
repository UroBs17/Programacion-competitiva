def insert(lista):
    for i in range(1,len(lista)):
        val = lista[i]
        pos = i
        while pos >0 and lista[pos-1]>val:
            lista[pos]=lista[pos-1]
            pos -=1
        lista[pos]= val
    return lista
