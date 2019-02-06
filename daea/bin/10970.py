from sys import stdin

def main():
    while True:
        line=stdin.readline().strip()
        if(len(line)==0):break
        a,b=[int(x) for x in line.split()]
        print(a*b-1)
main()
