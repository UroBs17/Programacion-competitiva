from sys import stdin
s=set(stdin.readline().strip().split())
k=set(stdin.readline().strip().split())
print(s&k)
