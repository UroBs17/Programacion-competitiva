from sys import stdin
def regex(ch1,ch2,line):
    line=line.split()
    P1=""
    P2=""
    for x in line:
        if x[:2]==ch1:
            for ch in x:
                P1+=ch
                if ch in "WVA":
                    break
        elif x[:2]==ch2:
            for ch in x:
                P2+=ch
                if ch in "WVA":
                    break
    return P1,P2      
def convert(v,exp):
    if "m" in exp:
        return v/1000
    if "k" in exp:
        return v*1000
    if "M" in exp:
        return v*1000000
    return v
def main():
    n=int(stdin.readline())
    for i in range(n):
        line=stdin.readline().strip()
        print("Problem #"+str(i+1))
        if "P=" in line and "U=" in line:
            P,U=regex("P=","U=",line)
            vP,vU=float(P.strip("P=WmkM")),float(U.strip("U=VmkM"))
            vP,vU=convert(vP,P),convert(vU,U)
            print("I=%.2fA"%(vP/vU))
        elif "P=" in line and "I=" in line:
            P,I=regex("P=","I=",line)
            vP,vI=float(P.strip("P=WmkM")),float(I.strip("I=AmkM"))
            vP,vI=convert(vP,P),convert(vI,I)
            print("U=%.2fV"%(vP/vI))
        elif "U=" in line and "I=" in line:
            U,I=regex("U=","I=",line)
            vU,vI=float(U.strip("U=VmkM")),float(I.strip("I=AmkM"))
            vU,vI=convert(vU,U),convert(vI,I)
            print("P=%.2fW"%(vU*vI))
        print()
main()
