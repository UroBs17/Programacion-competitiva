import datetime
from sys import stdin
from line import *

def leerInfo():
    """
PRE: Archivo con varios numeros a leer
POS: Se retorna la lista con todos los números contenidos en el archivo
"""
    info = []
    dato = stdin.readline().strip()
    print("comenzando...")
    while len(dato)>0:
        info.append(int(dato))
        dato = stdin.readline().strip()

    print("La longitud de la lista es:",len(info))
    return info

def main():
    lista = leerInfo()
    
    #Guardar la hora de inicio
    begin=datetime.datetime.now()
    print("INICIO:",begin)

    #Hacer el respectivo ordenamiento
    line(lista,-989898)

    #Guardar la  hora final
    fin=datetime.datetime.now()
    print("FIN:",fin)
    
    #Mostrar la diferencia de tiempo
    print("DELTA:",str(fin-begin))

main()
