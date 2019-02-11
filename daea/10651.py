from sys import stdin
dic={}
def solve(line):
    temp=line
    if temp in dic:
        return dic[temp]
    currNum=count(temp)
    if currNum<=1:
        dic[temp]=currNum
        return currNum
    for i in range(12):
        if (1<<i)&temp==0:
            continue
        if i-2>=0:
            if line[i-2]=="-" and line[i-1]=="o":
                temp1=line.copy()
                line[i-2]="o"
                line[i-1]="-"
                line[i]="-"
                currNum=min(currNum,solve(line))
                line=temp1
        if i+2<len(line):
            if line[i+2]=="-" and line[i+1]=="o":
                temp1=line.copy()
                line[i+2]="o"
                line[i+1]="-"
                line[i]="-"
                currNum=min(currNum,solve(line))
                line=temp1
    dic[temp]=currNum
    return currNum

def count(num):
    return 0
def main():
    n=int(stdin.readline().strip())
    for k in range(n):
        line=stdin.readline().strip()
        num=line.replace("o","1")
        num=num.replace("-","0")
        num=int(num,2)
        dic={}
        print(solve(num))
main()

