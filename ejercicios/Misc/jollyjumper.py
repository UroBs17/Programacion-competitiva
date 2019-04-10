from sys import stdin

def main():
    while True:
        line=stdin.readline().strip()
        if len(line)==0:break
        lista=[int(x) for x in line.split()]
        lista=lista[1:]
        list2=[]
        for i in range(len(lista)-1):
            list2.append(abs(lista[i]-lista[i+1]))
        list2.sort()
        v=True
        for i in range(len(list2)):
            v= v and i+1==list2[i]
        if v:
            print("Jolly")
        else:
            print("Not jolly")
main()
