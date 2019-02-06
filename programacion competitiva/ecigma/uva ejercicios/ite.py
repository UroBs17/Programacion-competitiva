def bina(lista,x):
    izq = 0
    der = len(lista)-1
    while izq <= der:
        mid = (izq+der)//2
        if lista[mid]==x:
            return mid
        elif lista[mid]>x:
            der = mid-1
        else:
            izq = mid +1
    return -1
