from sys import stdin
def main():
    n,m=[int(x) for x in stdin.readline().strip().split()]
    while n!=0 and m!=0:    
        set1=[]
        set2=[]
        for i in range(n):
            set1.append(int(stdin.readline()))
        for j in range(m):
            set2.append(int(stdin.readline()))
        x=set(set1)
        y=set(set2)
        print(len(x.intersection(y)))
        n,m=[int(x) for x in stdin.readline().strip().split()]
main()
