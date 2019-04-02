from sys import stdin
import math
def f(x,p,q,r,s,t,u):
    return p*((math.e)**(-x))+q*(math.sin(x))+r*(math.cos(x))+s*(math.tan(x))+t*(x**2)+u
def df(x,p,q,r,s,t):
    return -1*p*(math.e**(-x))+q*(math.cos(x))-r*(math.sin(x))+s/(math.cos(x)**2)+2*t*x
def newton(p,q,r,s,t,u):
    if f(0,p,q,r,s,t,u)==0:
        return 0
    x=0.5
    while True:
        nx=x-(f(x,p,q,r,s,t,u)/df(x,p,q,r,s,t))
        if(abs(x-nx)<(10**-7)):
            return x
        x=nx
def main():
    while True:
        s=stdin.readline().strip()
        if len(s)==0:
            break
        p,q,r,s,t,u=[int(x) for x in s.split()]
        if (f(0, p, q, r, s, t, u) * f(1, p, q, r, s, t, u) > 0):
            print("No solution")
        else:
            print('%.4f'%newton(p,q,r,s,t,u))
main()
