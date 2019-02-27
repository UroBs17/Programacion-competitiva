def cifradoV(s):
    s = list(s)
    for i in range(len(s)):
        s[i]= chr(ord(s[i])+1)
    return "".join(s)
def desCifradoV(s):
    s = list(s)
    for i in range(len(s)):
        s[i]= chr(ord(s[i])-1)
    return "".join(s)
def cifradoP(s):
    
    s = list(s)
    s=s[2:]+s[0:2]
    return "".join(s)
def desCifradoP(s):
    s = list(s)
    s=s[-2:]+s[0:-2]
    return "".join(s)

s="CAMISETA MILLONARIOS DECOLORA"

c= cifradoV(desCifradoP(s))
print(c)
res= cifradoP(desCifradoV(c))
print(res)

s="TODAS VENDIDAS"

c= cifradoP(desCifradoV(s))
print(c)
res= cifradoV(desCifradoP(c))
print(res)
