from sys import stdin
from bisect import bisect_right
fibArray=[0,1]

for i in range(200):
    fibArray.append(fibArray[-1]+fibArray[-2])

while True:
    n1 = stdin.readline().strip()
    if(len(n1)==0):
        break
    n2 = stdin.readline().strip()
    stdin.readline()
    if(n1=="0" and n2=="0"):
        print(0)
    else:
        n1 = n1[::-1]
        n2 = n2[::-1]
        n1 = sum(fibArray[i] for i in range(len(n1)) if n1[i] == '1')
        n2 = sum(fibArray[i] for i in range(len(n2)) if n2[i] == '1')
        n = n1 + n2
        idx = bisect_right(fibArray, n)
        result = []
        while idx >= 0:
            if n >= fibArray[idx]:
                result.append('1')
                n -= fibArray[idx]
            else:
                result.append('0')
            idx -= 1
        print("".join(result).lstrip('0'))
    print()
    
