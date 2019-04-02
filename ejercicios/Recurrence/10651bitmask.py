from sys import stdin
dic={}
def solve(num):
    temp=num
    if temp in dic:
        return dic[temp]
    currNum=count(temp)
    if currNum<=1:
        dic[temp]=currNum
        return currNum
    for i in range(12):
        if num&(1<<i)==0:
            continue
        if i-2>=0 and (num&(1<<(i-2)))==0 and (num & (1<<(i-1)))!=0:
            currNum=min(currNum,solve((num)&(~(1<<i))&(~(1<<(i-1)))|(1<<(i-2))))
        if i+2<12 and (num& (1<<(i+2)))==0 and (num& (1<<(i+1)))!=0:
            currNum=min(currNum,solve((num)&(~(1<<i))&(~(1<<(i+1)))|(1<<(i+2))))
    dic[num]=currNum
    return currNum
def count(num):
    c=0
    while num:
        c+=(num&1)
        num=num>>1
    return c
def main():
    n=int(stdin.readline().strip())
    for k in range(n):
        line=stdin.readline().strip()
        num=line.replace("-","0")
        num=num.replace("o","1")
        num=int(num,2)
        dic={}
        print(solve(num))
main()
