def bubble(lista):
    for i in range(1,len(lista)):
        for j in range(len(lista)-i):
            if lista[j] > lista[j+1]:
                lista[j],lista[j+1]=lista[j+1],lista[j]
    return lista
