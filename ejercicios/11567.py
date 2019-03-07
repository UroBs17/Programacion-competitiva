from sys import stdin

def main():
    while True:
        line=stdin.readline().strip()
        if len(line)==0:break
        n=int(line)
        count=0
        while n>0:
            if n%2==0:
                n=n//2
            else:
                if ((n-1)//2)%2==0 or ((n-1)//2)==1:
                    n-=1
                else:
                    n+=1

            count+=1
        print(count)

main()
