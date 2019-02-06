from sys import stdin

def main():
    while True:
        line=stdin.readline().strip()
        if len(line)==0:break
        a,b=[int(x) for x in line.split()]
        flag=True
        l=[]
        while a>1:
            if a%b==0:
                l.append(a)
                a=a//b
            else:
                flag=False
                break
        l.append(1)
        if flag:
            print(" ".join([str(x) for x in l]))
        else:
            print("Boring!")
        
main()
