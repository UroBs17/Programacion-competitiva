"""
#two ends
"""
from sys import stdin
def solve(juego,i,j):
    global dic
    if str(i)+"-"+str(j) in dic:
        return dic[str(i)+"-"+str(j)]
    elif j==i+1:
        return abs(juego[i]-juego[j])
    elif i==j+1:
        return 0
    elif j-i+1>2:
        if juego[i+1]>=juego[j]:
            izq=juego[i]-juego[i+1]+solve(juego,i+2,j)
        elif juego[i+1]<juego[j]:
            izq=juego[i]-juego[j]+solve(juego,i+1,j-1)
        if juego[i]>=juego[j-1]:
            der=juego[j]-juego[i]+solve(juego,i+1,j-1)
        elif juego[i]<juego[j-1]:
            der=juego[j]-juego[j-1]+solve(juego,i,j-2)
        dic[str(i)+"-"+str(j)]=max(izq,der)
        return dic[str(i)+"-"+str(j)]
def main():
    global dic
    juego=[int(x) for x in stdin.readline().strip().split()]
    v=1
    while juego[0]!=0:
        dic={}
        x=juego.pop(0)
        print("In game "+str(v)+", the greedy strategy might lose by as many as "+str(solve(juego,0,x-1))+" points.")
        juego=[int(x) for x in stdin.readline().strip().split()]
        v+=1
main()
