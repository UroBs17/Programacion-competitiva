from sys import stdin
dic={}
def solve(line):
    temp="".join(line)
    if temp in dic:
        return dic[temp]
    currNum=line.count("o")
    if currNum<=1:
        dic[temp]=currNum
        return currNum
    for i in range(12):
        if line[i]=="-":
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
            
def main():
    n=int(stdin.readline().strip())
    for k in range(n):
        line=list(stdin.readline().strip())
        dic={}
        print(solve(line))
main()
