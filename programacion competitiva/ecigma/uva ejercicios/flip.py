from sys import stdin
def solve(arr):
    n=0
    for i in range(len(arr)):
        for j in range(i+1,len(arr)):
            if arr[i]>arr[j]:
                n+=1
    print(n)
def main():
    n=stdin.readline().strip()
    lista=[int(x) for x in stdin.readline().strip().split()]
    solve(lista)
main()
        
