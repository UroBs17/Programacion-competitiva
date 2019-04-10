#1 2-> 2 1
#3 4-> 4 2
#3 5-> 5 3
#3 1-> 5 4
#/2 3-> 5 5 != 1
#/4 1-> 5 5 != 2
#2 6-> 6 5
#/6 5 -> 6 6 !=3
from sys import stdin

def main():
    p=[int(x) for x in stdin.readline().strip().split()]
    x=set()
    mezcla=0
    n=0
    while len(p)!=0:
        num1,num2=p[0],p[1]
        p1=num1 in x
        p2=num2 in x
        x.add(num1)
        x.add(num2)
        mezcla+=1
        if len(x)==mezcla:
            n+=1
            mezcla-=1
            if not p1:
                x.remove(num1)
            if not p2:
                x.remove(num2)
        p=[int(x) for x in stdin.readline().strip().split()]
        if len(p)==1:
            print(n)
            x=set()
            mezcla=0
            n=0
            blank=stdin.readline()
            p=[int(x) for x in stdin.readline().strip().split()]
main()
