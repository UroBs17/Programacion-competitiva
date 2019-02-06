from sys import stdin
def post(exp,dic):
    pila=[]
    expr=[]
    for i in range(len(exp)):
        if exp[i]==" ":
            continue
        if exp[i]=="(":
            pila.append(exp[i])
        elif exp[i]=="V" or exp[i]=="F":
            expr.append(exp[i])
        elif exp[i]==")":
            while pila[-1]!="(":
                expr.append(pila.pop())
            pila.pop()
        else:
            if exp[i]=="!" and len(pila)>0 and pila[-1]=="!":
                pila.append(exp[i])
            else:
                while len(pila)>0 and pila[-1] in dic and dic[exp[i]]<=dic[pila[-1]]:
                    expr.append(pila.pop())
                pila.append(exp[i])
    while pila:
        expr.append(pila.pop())
    return expr
def solve(x):
    stack=[]
    for elem in x:
        if elem == "V":
            stack.append(True)
        elif elem=="F":
            stack.append(False)
        elif elem == "!":
            x= stack.pop()
            stack.append(not x)
        elif elem == "&":
            x=stack.pop()
            y=stack.pop()
            stack.append(x and y)
        elif elem == "|":
            x=stack.pop()
            y=stack.pop()
            stack.append(x or y)
    return stack[0]
def main():
    exp=stdin.readline().strip()
    dic={"&":2,"|":1,"!":3}
    n=1
    while exp:
        x=post(exp,dic)
        print(x)
        g=solve(x)
        if g:
            print("Expression "+str(n)+": V")
        else:
            print("Expression "+str(n)+": F")
        exp=stdin.readline().strip()
        n+=1
main()
