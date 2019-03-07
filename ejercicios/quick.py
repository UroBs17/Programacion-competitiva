def quick(lista):
    if len(lista)==0:
        return []
    else:
        pivote = lista[0]
        izq,der=quick([x for x in lista[1:] if x < pivote]),quick([x for x in lista[1:] if x >= pivote])
        return izq+[pivote]+der
