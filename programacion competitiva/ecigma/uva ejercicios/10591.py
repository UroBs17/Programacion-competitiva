from sys import stdin

def main():
    case=int(stdin.readline())
    for i in range(case):
        line=stdin.readline().strip()
        if len(line)==0:break
        setA= set()
        num=int(line)
        yes=True
        while True:
            if num in setA:
                yes=False
                break
            if num==1:
                break
            setA.add(num)
            num=sum([int(x)**2 for x in list(str(num))])
        if yes:
            print("Case #{}: {} is a Happy number.".format(i+1,line))
        else:
            print("Case #{}: {} is an Unhappy number.".format(i+1,line))
main()
