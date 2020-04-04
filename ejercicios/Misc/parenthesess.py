from sys import stdin

def main():
    t=int(stdin.readline())
    for case in range(t):
        digits=stdin.readline().strip()
        rta=""
        prev=0
        for i in range(len(digits)):
            curr=int(digits[i])
            diff=curr-prev
            if diff<0:
                rta+=")"*(abs(diff))
            elif diff>0:
                rta+="("*(abs(diff))
            rta+=digits[i]
            prev=curr
        rta+=")"*prev
        print("Case #"+str(case+1)+": "+rta)
main()
