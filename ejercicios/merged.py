def mergeSort(lista):
    if len(lista) == 1:
        return lista
    else:
        mid = len(lista)//2
        list1, list2 = mergeSort(lista[:mid]),mergeSort(lista[mid:])
        return merge(list1,list2)
def merge(list1,list2):
    lista = []
    i,j = 0,0
    while i < len(list1) and j < len(list2):
        if list1[i] < list2[j]:
            lista.append(list1[i])
            i += 1
        else:
            lista.append(list2[j])
            j += 1
    lista.extend(list1[i:])
    lista.extend(list2[j:])
    return lista
        
