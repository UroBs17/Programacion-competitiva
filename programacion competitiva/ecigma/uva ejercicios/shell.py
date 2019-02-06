def shell(lista):
    div = len(lista)//2
    while div > 0:
        for i in range(div,len(lista)):
            val = lista[i]
            j = i
            while j>=div and lista[j-div]>val:
                lista[j]= lista[j-div]
                j -= div
            lista[j]= val
        div = div//2
    return lista
