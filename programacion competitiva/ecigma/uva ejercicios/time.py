from sys import stdin
lista=["-","+","/","*"]
def f(exp):
    global lista
    x=[]
    n=""
    v=0
    for i in range(len(exp)):
        u=exp[i]
        if i==0 and u=="-":
            n+="-"
            v+=1
            #print("primer if i==0 and u== -:",n,v)
        if i==0 and u=="+":
            #print("segundo if i==0 and u== +:",n,v)
            continue
        elif u=="-" and exp[i-1] in lista and i!=0:
            n+="-"
            v+=1
            #print("tercer elif u== - and exp[i-1] in lista:",n,v)
        elif u=="+" and exp[i-1] in lista and i!=0:
            #print("cuarto elif u== + and exp[i-1] in lista:",n,v)
            continue
        elif u in lista and exp[i-1] not in lista and i!=0:
            g=float(n[v:])*((-1)**v)
            x.append(g)
            x.append(exp[i])
            #print("quinto elif u in lista and exp[i-1] not in lista:",n,v)
            n=""
            v=0
        elif u != "+" and u!="-" and u!="*" and u!="/":
            n+=exp[i]
            #print("else",n,v)
    g=float(n[v:])*((-1)**v)
    x.append(g)
    return x
def evalue(j):
    h=[]
    for i in range(len(j)):
        h.append(j[i])
        if len(h)>2 and h[-2]=="*":
            temp=h.pop()
            h.pop()
            h.append(h.pop()*temp)
        if len(h)>2 and h[-2]=="/":
            temp=h.pop()
            h.pop()
            h.append(h.pop()/temp)
    y=[]
    for i in range(len(h)):
        y.append(h[i])
        if len(y)>2 and y[-2]=="+":
            temp=y.pop()
            y.pop()
            y.append(y.pop()+temp)
        if len(y)>2 and y[-2]=="-":
            temp=y.pop()
            y.pop()
            y.append(y.pop()-temp)
    print("%.3f"%y[0])
def main():
    exp=stdin.readline().strip()
    while exp:
        g=f(exp)
        evalue(g)
        exp=stdin.readline().strip()
main()
