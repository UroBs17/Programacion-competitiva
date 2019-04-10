def busque(lista,x):
    if len(lista)==0:
        return False
    else:
        mid = len(lista)//2
        if lista[mid] == x:
            return True
        elif lista[mid] > x:
            return busque(lista[:len(lista)//2],x)
        elif lista[mid] < x:
            return busque(lista[(len(lista)//2)+1:],x)
    return False
